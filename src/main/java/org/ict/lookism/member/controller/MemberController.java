package org.ict.lookism.member.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.security.Principal;
import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.service.EmailVerification;
import org.ict.lookism.member.service.MemberService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService members;
    private final EmailVerification verification;

    public MemberController(MemberService members, EmailVerification verification) {
        this.members = members;
        this.verification = verification;
    }

    @GetMapping("/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }

    @GetMapping("/signup-options")
    public SignupOptions signupOptions() {
        return new SignupOptions(verification.required());
    }

    @PostMapping("/email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void email(@RequestParam @NotBlank @Email @Size(max = 254) String email, HttpSession session) {
        verification.send(session, MemberService.normalizeEmail(email));
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody SignupRequest request, HttpSession session) {
        String email = MemberService.normalizeEmail(request.userEmail());
        synchronized (session) {
            verification.verify(session, email, request.emailCode());
            try {
                members.signUp(email, request);
            } catch (DataIntegrityViolationException error) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Account could not be created");
            }
            verification.consume(session);
        }
    }

    @GetMapping("/me")
    public Profile me(Principal principal) {
        Member member = members.getMember(principal.getName());
        return new Profile(member.getEmail(), member.getName());
    }

    public record Profile(String email, String name) {}
    public record SignupOptions(boolean emailVerificationRequired) {}
}
