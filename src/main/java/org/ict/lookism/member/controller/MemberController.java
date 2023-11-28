package org.ict.lookism.member.controller;

import org.ict.lookism.member.entity.Member;
import org.ict.lookism.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RestController
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;



	@RequestMapping("selectlogin.do")
	public String selectLoginMethod(
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "pwd", required = false) String pwd,
			Model model) {
		Member member = new Member();
		member.setUserId(id);
		member.setUserPwd(pwd);
		int loginResult = memberService.selectLogin(member);

		if (loginResult == 1) {
			// 로그인 성공
			return "redirect:/home";
		} else {
			// 로그인 실패
			model.addAttribute("error", "Invalid credentials");
			return "loginPage";
		}
	}

	@RequestMapping(value = "memberUpdate.do", method = RequestMethod.POST)
	public String memberUpdateMethod(Member member, Model model) {
		int result = memberService.updateMember(member);

		if (result == 1) {
			// 회원 정보 수정 성공
			return "redirect:/memberList";
		} else {
			// 회원 정보 수정 실패
			model.addAttribute("error", "Failed to update member information");
			return "errorPage";
		}
	}

	// 회원 삭제 요청 처리용
	@RequestMapping(value = "memberDelete.do", method = RequestMethod.POST)
	public String memberDeleteMethod(Member member, Model model) {
		int result = memberService.deleteMember(member);

		if (result == 1) {
			// 회원 삭제 성공
			return "redirect:/memberList";
		} else {
			// 회원 삭제 실패
			model.addAttribute("error", "Failed to delete member");
			return "errorPage"; // 에러 페이지의 뷰 이름을 설정하세요.
		}
	}

	// 회원 목록 조회 요청 처리용
	@RequestMapping("memberList.do")
	public String memberListMethod(Model model) {
		List<Member> memberList = memberService.selectMemberList(null); // null 대신 필요한 검색 조건을 전달하세요.
		model.addAttribute("memberList", memberList);
		return "memberList"; // 회원 목록을 보여줄 뷰 이름을 설정하세요.
	}
}














