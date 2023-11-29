package org.ict.lookism.utils;

// JwtService.java
import org.ict.lookism.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String createToken(Member member);

    boolean isTokenValid(String token);

    Long getUserIdFromToken(String token);

}
