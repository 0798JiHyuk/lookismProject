package org.ict.lookism.mystar.controller;

import org.ict.lookism.mystar.entity.MyStar;
import org.ict.lookism.mystar.service.MyStarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyStarController {
	private static final Logger logger = LoggerFactory.getLogger(MyStarController.class);

	@Autowired
	private MyStarService myStarService;

	@RequestMapping(value = "addMyStar.do", method = RequestMethod.POST)
	public String addMyStarMethod(MyStar myStar) {
		// 적절한 로직을 추가하여 MyStar 추가 기능을 구현하세요.
		return "redirect:/home"; // 수정 필요
	}

	@RequestMapping(value = "removeMyStar.do", method = RequestMethod.POST)
	public String removeMyStarMethod(MyStar myStar) {
		// 적절한 로직을 추가하여 MyStar 제거 기능을 구현하세요.
		return "redirect:/home"; // 수정 필요
	}

	// 적절한 URL 및 메서드를 추가하여 필요한 기능을 구현하세요.
}