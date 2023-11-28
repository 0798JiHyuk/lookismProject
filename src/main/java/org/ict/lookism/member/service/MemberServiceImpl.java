package org.ict.lookism.member.service;

import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberMapper;

	@Override
	public int selectLogin(Member member) { return memberMapper.selectLogin(member); }

	@Override
	public int insertMember(Member member){ return memberMapper.insertMember(member); }

	@Override
	public int updateMember(Member member){ return memberMapper.updateMember(member); }

	@Override
	public int deleteMember(Member member){ return memberMapper.deleteMember(member); }

	@Override
	public List<Member> selectMemberList(Member member){ return memberMapper.selectMemberList(); }
}











