package org.ict.lookism.coin.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.coin.entity.Coin;
import org.ict.lookism.coin.service.CoinService;
import org.ict.lookism.common.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/coin")
public class CoinController {
	//이 컨트롤러 안의 메소드들이 구동되는지, 값이 잘 전달되었는지 확인을 위한 로그 객체를 생성
	
	@Autowired
	private CoinService coinService;
	
	//사용내역 목록보기 카운트에 대한 처리
	@GetMapping("/listCount/{userId}")
	public int selectListCount(String userId) {
	    return 0;
	}
	
	//사용내역 목록보기 요청 처리용 (페이징 처리)
	@GetMapping("/usedList/{userId}")
	public List<Coin> selectUsedList(Paging paging, String userId) {
		return null;
	}
	//이상형 매칭 아이템 사용 요청 처리용 (페이징 처리)
	@PostMapping("/Iinsert") 
	public int insertICoin(Coin coin) {
		return 0;
	}
	
	//랜덤 채팅 아이템 사용 요청 처리용 (페이징 처리)
	@PostMapping("/Rinsert") 
	public int insertRCoin(Coin coin) {
		return 0;
	}

	
}














