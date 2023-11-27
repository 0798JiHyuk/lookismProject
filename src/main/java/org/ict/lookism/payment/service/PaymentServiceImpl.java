package org.ict.lookism.payment.service;


import org.ict.lookism.common.Paging;
import org.ict.lookism.payment.entity.Payment;
import org.ict.lookism.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public int selectListCount(String userId) {
		return paymentRepository.selectListCount(userId);
	}

	@Override
	public List<Payment> selectList(Paging paging, String userId) {
		List<Payment> list = paymentRepository.selectList(paging, userId);
		return (ArrayList<Payment>) list;
	}

	@Override
	public int insertPayment(Payment payment) {
		return paymentRepository.insertPayment(payment);
	}

	@Override
	public int updatePayment(Payment payment, String paymentId) {
		return paymentRepository.updatePayment(paymentId);
	}

}
