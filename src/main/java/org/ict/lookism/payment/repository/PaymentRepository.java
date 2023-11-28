package org.ict.lookism.payment.repository;

import org.ict.lookism.common.Paging;
import org.ict.lookism.files.entity.Files;
import org.ict.lookism.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository {  //클래스명과 매퍼 xml 파일명이 같아야 함
	
	public int selectListCount(String userId);
	public List<Payment> selectList(Paging paging, String userId);
	public int insertPayment(Payment payment);
	public int updatePayment(String paymentId);
}
