package org.ict.lookism.member.service;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.ict.lookism.member.controller.SignupRequest;
import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository members;
    private final PasswordEncoder passwords;

    public MemberService(MemberRepository members, PasswordEncoder passwords) {
        this.members = members;
        this.passwords = passwords;
    }

    public void signUp(String email, SignupRequest request) {
        if (request.userPwd().getBytes(StandardCharsets.UTF_8).length > 72) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password exceeds 72 bytes");
        }
        if (members.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already registered");
        }
        members.saveAndFlush(new Member(email, passwords.encode(request.userPwd()), request));
    }

    @Override
    public UserDetails loadUserByUsername(String input) {
        Member member = members.findByEmail(normalizeEmail(input))
                .orElseThrow(() -> new UsernameNotFoundException("Unknown account"));
        return User.withUsername(member.getEmail()).password(member.getPasswordHash()).roles("MEMBER").build();
    }

    public Member getMember(String email) {
        return members.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
    }

    public static String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }
}
