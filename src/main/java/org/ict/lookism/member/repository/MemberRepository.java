package org.ict.lookism.member.repository;

import org.apache.ibatis.annotations.*;
import org.ict.lookism.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);

    Member findByUserEmail(String userEmail);

}
