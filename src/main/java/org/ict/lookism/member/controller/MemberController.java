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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Validated @RequestBody MemberVo memberVo) {
		System.out.println("signupMethod test1");
		Member member = convertToEntity(memberVo);

		Member createdMember = memberService.signUp(member);

		return ResponseEntity.ok("Member created successfully");
	}

	private Member convertToEntity(MemberVo memberVo) {
		Member member = new Member();
		member.setUserEmail(memberVo.getUserEmail());
		member.setUserName(memberVo.getUserName());
		member.setUserBirth(memberVo.getUserBirth());
		member.setUserPhone(memberVo.getUserPhone());
		member.setUserPwd(memberVo.getUserPwd());
		member.setUserHeight(memberVo.getUserHeight());
		member.setUserWeight(memberVo.getUserWeight());
		member.setUserCigarette(memberVo.getUserCigarette());
		member.setUserDrinking(memberVo.getUserDrinking());
		member.setUserReligion(memberVo.getUserReligion());
		member.setUserProfile(memberVo.getUserProfile());
		member.setUserLevel(memberVo.getUserLevel());

		return member;
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

	@PostMapping("/email")
	public Map<String, Object> email(@RequestParam String email) {
		Map<String, Object> map = new HashMap<>();
		Member member = memberService.getMember(email);
		System.out.println("emailMethodtest1 : " + member);
		if (member != null) {
			map.put("exist", "이미 존재하는 이메일입니다.");
		} else {
			Random random = new Random();
			StringBuilder key = new StringBuilder();

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);

			for (int i = 0; i < 3; i++) {
				int index = random.nextInt(26) + 65;
				key.append((char) index);
			}
			for (int i = 0; i < 6; i++) {
				int numIndex = random.nextInt(10);
				key.append(numIndex);
			}

			String mailSubject = "\n Lookism 회원가입 이메일 인증";
			message.setSubject("회원가입을 위한 이메일 인증번호 메일입니다.");
			message.setText("인증번호는 " + key.toString() + " 입니다." + mailSubject);

			try {
				javaMailSender.send(message);
				map.put("key", key.toString());
				map.put("memberVo", member);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("error", "이메일 전송에 실패했습니다.");
			}
		}
		return map;
	}
}
