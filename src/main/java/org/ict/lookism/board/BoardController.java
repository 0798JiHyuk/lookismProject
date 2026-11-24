package org.ict.lookism.board;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.security.Principal;
import java.time.Instant;
import java.util.List;
import org.ict.lookism.member.service.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardRepository posts;
    private final MemberService members;

    BoardController(BoardRepository posts, MemberService members) {
        this.posts = posts;
        this.members = members;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public PostPage list(Principal user, @RequestParam(defaultValue = "0") int page) {
        var result = posts.findAll(PageRequest.of(Math.max(0, Math.min(page, 10000)), 20,
                Sort.by(Sort.Direction.DESC, "id")));
        return new PostPage(result.map(post -> view(post, user)).getContent(), result.hasNext());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public PostView read(@PathVariable long id, Principal user) {
        return view(find(id), user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public PostView create(@Valid @RequestBody PostInput input, Principal user) {
        var post = new BoardPost(members.getMember(user.getName()), input.title().strip(), input.body().strip());
        return view(posts.save(post), user);
    }

    @PatchMapping("/{id}")
    @Transactional
    public PostView update(@PathVariable long id, @Valid @RequestBody PostInput input, Principal user) {
        var post = ownedPost(id, user);
        post.title = input.title().strip();
        post.body = input.body().strip();
        return view(post, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable long id, Principal user) {
        posts.delete(ownedPost(id, user));
    }

    @ExceptionHandler(org.springframework.orm.ObjectOptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void concurrentUpdate() {}

    private BoardPost find(long id) {
        return posts.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private BoardPost ownedPost(long id, Principal user) {
        var post = find(id);
        if (!post.author.getEmail().equals(user.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return post;
    }

    private PostView view(BoardPost post, Principal user) {
        return new PostView(post.id, post.title, post.body, post.author.getName(), post.createdAt,
                post.author.getEmail().equals(user.getName()));
    }

    public record PostInput(@NotBlank @Size(max = 120) String title, @NotBlank @Size(max = 4000) String body) {}
    public record PostView(long id, String title, String body, String author, Instant createdAt, boolean mine) {}
    public record PostPage(List<PostView> posts, boolean hasNext) {}
}
