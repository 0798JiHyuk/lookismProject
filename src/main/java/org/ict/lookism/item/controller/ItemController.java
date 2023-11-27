package org.ict.lookism.item.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.item.entity.Item;
import org.ict.lookism.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
	//이 컨트롤러 안의 메소드들이 구동되는지, 값이 잘 전달되었는지 확인을 위한 로그 객체를 생성
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public List<Item> selectList() {
		return null;
	}

	//아이템 할인율 변경 요청 처리용
	@PatchMapping("/update/{itemId}") 
	public int updateDiscItem(String itemId) {
		return 0;
	}

	
}














