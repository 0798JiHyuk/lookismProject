package org.ict.lookism.looks.controller;

import org.ict.lookism.looks.entity.Looks;
import org.ict.lookism.looks.service.LooksService;
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
public class LooksController {
	private static final Logger logger = LoggerFactory.getLogger(LooksController.class);

	@Autowired
	private LooksService looksService;

	public String selectLoginMethod(
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "pwd", required = false) String pwd,
			Model model) {
		// Your login logic here using LooksService
		return "redirect:/home"; // Modify the redirect URL accordingly
	}

	public String looksUpdateMethod(Looks looks, Model model) {
		int result = looksService.updateLooks(looks);

		if (result == 1) {
			// Looks 정보 수정 성공
			return "redirect:/looksList";
		} else {
			// Looks 정보 수정 실패
			model.addAttribute("error", "Failed to update looks information");
			return "errorPage";
		}
	}

	// Looks 삭제 요청 처리용
	public String looksDeleteMethod(@RequestParam("userId") String userId, Model model) {
		int result = looksService.deleteLooks(userId);

		if (result == 1) {
			// Looks 삭제 성공
			return "redirect:/looksList";
		} else {
			// Looks 삭제 실패
			model.addAttribute("error", "Failed to delete looks");
			return "errorPage"; // 에러 페이지의 뷰 이름을 설정하세요.
		}
	}

	// Looks 목록 조회 요청 처리용
	public String looksListMethod(Model model) {
		List<Looks> looksList = looksService.selectLooksList();
		model.addAttribute("looksList", looksList);
		return "looksList"; // Looks 목록을 보여줄 뷰 이름을 설정하세요.
	}
}