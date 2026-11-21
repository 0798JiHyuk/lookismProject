package org.ict.lookism.member.service;

import jakarta.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmailVerification {
    private static final String CHALLENGE = EmailVerification.class.getName();
    private static final Duration VALIDITY = Duration.ofMinutes(10);
    private static final Duration RESEND_DELAY = Duration.ofMinutes(1);
    private final SecureRandom random = new SecureRandom();

    private final ObjectProvider<JavaMailSender> mail;
    private final String from;
    private final boolean required;

    public EmailVerification(ObjectProvider<JavaMailSender> mail,
                             @Value("${lookism.mail.from}") String from,
                             @Value("${lookism.mail.required}") boolean required) {
        this.mail = mail;
        this.from = from;
        this.required = required;
    }

    public boolean required() { return required; }

    public void send(HttpSession session, String email) {
        synchronized (session) {
            Instant now = Instant.now();
            Challenge previous = (Challenge) session.getAttribute(CHALLENGE);
            if (previous != null && now.isBefore(previous.issuedAt().plus(RESEND_DELAY))) {
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Wait before requesting a new code");
            }
            JavaMailSender sender = mail.getIfAvailable();
            if (sender == null || from.isBlank()) {
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Email delivery is unavailable");
            }
            String code = String.format(Locale.ROOT, "%08d", random.nextInt(100_000_000));
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(email);
            message.setSubject("Lookism email verification");
            message.setText("Verification code: " + code + ". This code expires in 10 minutes.");
            try {
                sender.send(message);
            } catch (MailException error) {
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Email delivery is unavailable");
            }
            session.setAttribute(CHALLENGE, new Challenge(email, code, now, 5));
        }
    }

    public void verify(HttpSession session, String email, String code) {
        if (!required) return;
        Challenge challenge = (Challenge) session.getAttribute(CHALLENGE);
        if (challenge == null || challenge.remainingAttempts() == 0
                || !Instant.now().isBefore(challenge.issuedAt().plus(VALIDITY))) {
            throw invalidCode();
        }
        if (!challenge.email().equals(email) || !challenge.code().equals(code)) {
            session.setAttribute(CHALLENGE, new Challenge(challenge.email(), challenge.code(),
                    challenge.issuedAt(), challenge.remainingAttempts() - 1));
            throw invalidCode();
        }
    }

    public void consume(HttpSession session) {
        session.removeAttribute(CHALLENGE);
    }

    private ResponseStatusException invalidCode() {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid or expired email verification code");
    }

    private record Challenge(String email, String code, Instant issuedAt, int remainingAttempts) {}
}
