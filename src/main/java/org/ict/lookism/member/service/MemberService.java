package org.ict.lookism.member.service;

import org.ict.lookism.exception.UnauthorizedException;
import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.repository.MemberRepository;
import org.ict.lookism.member.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Member signUp(Member member) {
		member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));
		return memberRepository.save(member);
	}

	public Member signIn(String userEmail, String userPwd) {
		Member member = memberRepository.findByUserEmail(userEmail);

//		if (member != null && passwordEncoder.matches(userPwd, member.getUserPwd())) {
		if (member != null && passwordEncoder.matches(userPwd, member.getUserPwd())) {
			System.out.println("login success!");
			System.out.println(member.getUserPwd());
			return member;
		}
		System.out.println("login failed!");
		// 로그인 실패 시 예외 처리
		throw new UnauthorizedException("Invalid email or password");
	}

	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}
}
