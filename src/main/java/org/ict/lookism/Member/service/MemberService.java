package org.ict.lookism.Member.service;

import org.ict.lookism.member.entity.Member;

import java.util.List;

public interface MemberService {

    int selectLogin(Member member);

    int insertMember(Member member);

    int updateMember(Member member);


    int deleteMember(Member member);

    List<Member> selectMemberList(Member member);
}
