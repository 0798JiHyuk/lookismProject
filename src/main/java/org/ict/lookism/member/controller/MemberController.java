package org.ict.lookism.member.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.exception.UnauthorizedException;
import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.service.MemberService;
import org.ict.lookism.member.vo.MemberVo;
import org.ict.lookism.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Validated @RequestBody Member member) {
		Member createdMember = memberService.signUp(member);
		return new ResponseEntity<>("Member created with ID: " + createdMember.getUserId(), HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<String> signIn(@RequestBody Map<String, String> credentials) {
		String userEmail = credentials.get("userEmail");
		String userPwd = credentials.get("userPwd");
		System.out.println(userEmail);
		System.out.println(userPwd);
		try {
			Member member = memberService.signIn(userEmail, userPwd);
			if(member != null){
				return new ResponseEntity<>("Member signed in successfully", HttpStatus.OK);
			}else{
				throw new UnauthorizedException("유효하지 않은 이메일 또는 비밀번호");
			}
			// JWT 토큰 생성 및 반환 로직 추가
		}catch(UnauthorizedException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}


	}

	@GetMapping("/all")
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = memberService.getAllMembers();
		return new ResponseEntity<>(members, HttpStatus.OK);
	}
}
