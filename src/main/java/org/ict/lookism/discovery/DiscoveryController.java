package org.ict.lookism.discovery;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.ict.lookism.member.service.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
    private final DiscoveryRepository profiles;
    private final InterestRepository interests;
    private final MemberService members;

    DiscoveryController(DiscoveryRepository profiles, InterestRepository interests, MemberService members) {
        this.profiles = profiles;
        this.interests = interests;
        this.members = members;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public DiscoveryPage browse(Principal user, @RequestParam(defaultValue = "0") int page) {
        long id = members.getMember(user.getName()).getId();
        var own = profiles.findById(id);
        var settings = own.map(p -> new Settings(p.visible, p.introduction)).orElse(new Settings(false, ""));
        if (!settings.visible()) return new DiscoveryPage(settings, List.of(), false);

        var results = profiles.findByVisibleTrueAndIdNot(id,
                PageRequest.of(Math.max(0, Math.min(page, 10000)), 20, Sort.by("id")));
        var ids = results.map(profile -> profile.id).getContent();
        var outgoing = interests.findBySenderIdAndTargetIdIn(id, ids).stream()
                .map(interest -> interest.target.getId()).collect(Collectors.toSet());
        var incoming = interests.findByTargetIdAndSenderIdIn(id, ids).stream()
                .map(interest -> interest.sender.getId()).collect(Collectors.toSet());
        var cards = results.map(p -> new Card(p.id, p.member.getName(), p.introduction,
                outgoing.contains(p.id), outgoing.contains(p.id) && incoming.contains(p.id))).getContent();
        return new DiscoveryPage(settings, cards, results.hasNext());
    }

    @PutMapping("/profile")
    @Transactional
    public Settings update(@Valid @RequestBody Settings input, Principal user) {
        var member = members.getMember(user.getName());
        var locked = profiles.lockProfiles(List.of(member.getId()));
        var profile = locked.isEmpty() ? new DiscoveryProfile(member) : locked.get(0);
        profile.visible = input.visible();
        profile.introduction = input.introduction().strip();
        profiles.save(profile);
        if (!profile.visible) interests.deleteBySenderIdOrTargetId(member.getId(), member.getId());
        return new Settings(profile.visible, profile.introduction);
    }

    @PutMapping("/{targetId}/interest")
    @Transactional
    public InterestState interest(@PathVariable long targetId, @Valid @RequestBody InterestInput input, Principal user) {
        long senderId = members.getMember(user.getName()).getId();
        if (senderId == targetId) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        var locked = profiles.lockProfiles(List.of(senderId, targetId));
        var sender = locked.stream().filter(p -> p.id == senderId && p.visible).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));
        var target = locked.stream().filter(p -> p.id == targetId && p.visible).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!input.interested()) {
            interests.deleteBySenderIdAndTargetId(senderId, targetId);
            return new InterestState(false, false);
        }
        if (!interests.existsBySenderIdAndTargetId(senderId, targetId)) {
            interests.save(new Interest(sender.member, target.member));
        }
        return new InterestState(true, interests.existsBySenderIdAndTargetId(targetId, senderId));
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void concurrentProfileUpdate() {}

    public record Settings(@NotNull Boolean visible, @NotNull @Size(max = 500) String introduction) {}
    public record InterestInput(@NotNull Boolean interested) {}
    public record InterestState(boolean interested, boolean matched) {}
    public record Card(long id, String name, String introduction, boolean interested, boolean matched) {}
    public record DiscoveryPage(Settings settings, List<Card> profiles, boolean hasNext) {}
}
