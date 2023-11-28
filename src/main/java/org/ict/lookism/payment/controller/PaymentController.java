package org.ict.lookism.payment.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.payment.entity.Payment;
import org.ict.lookism.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
//@RestController
public class PaymentController {
	//이 컨트롤러 안의 메소드들이 구동되는지, 값이 잘 전달되었는지 확인을 위한 로그 객체를 생성
	

	private final PaymentService paymentService;
	
	//구매내역 목록보기 요청 처리용 (페이징 처리)
	@GetMapping("/list/{userId}")
	public List<Payment> selectList(Payment payment, String userId) {
		return null;
	}
	//구매내역 목록보기 카운트 요청 처리용 (페이징 처리)
	@GetMapping("/listcount/{userId}")
	public int selectListCount(String userId) {
	    // 구매내역 목록보기 카운트에 대한 처리
	    return 0;
	}

	// 구매 요청 처리용 (페이징 처리)
	@PostMapping("/pinsert")
	public int insertPayment(Payment payment) {
	    // 구매 요청에 대한 처리
	    return 0;
	}

	// 환불 요청 처리용 (페이징 처리)
	@PatchMapping("/pupdate")
	public int updatePayment(Payment payment, String paymentId) {
	    // 환불 요청에 대한 처리
	    return 0;
	}

	
}














