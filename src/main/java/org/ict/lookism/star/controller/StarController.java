package org.ict.lookism.star.controller;

import org.ict.lookism.star.service.StarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StarController {
	private static final Logger logger = LoggerFactory.getLogger(StarController.class);

	@Autowired
	private StarService starService;

	// 적절한 URL 및 메서드를 추가하여 필요한 기능을 구현하세요.
}