package org.ict.lookism.payment.repository;

import org.ict.lookism.common.Paging;
import org.ict.lookism.payment.entity.Payment;

import java.util.List;


public interface PaymentRepository {  //클래스명과 매퍼 xml 파일명이 같아야 함
	
	public int selectListCount(String userId);
	public List<Payment> selectList(Paging paging, String userId);
	public int insertPayment(Payment payment);
	public int updatePayment(String paymentId);
}
