package org.ict.lookism.Member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ict.lookism.member.entity.Member;

import java.util.List;

@Mapper
public interface MemberRepository {  //클래스명과 매퍼 xml 파일명이 같아야 함
	//간단한 쿼리문일 때는 어노테이션 방식이 편함
	@Select("select sysdate from dual")
	public String getTime();
	
	public int selectLogin(Member member);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(Member member);
	public List<Member> selectMemberList();

}
