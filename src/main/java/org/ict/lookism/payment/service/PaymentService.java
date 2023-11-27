package org.ict.lookism.payment.service;

import org.ict.lookism.common.Paging;
import org.ict.lookism.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
	
    int selectListCount(String userId);

    List<Payment> selectList(Paging paging, String userId);

    int insertPayment(Payment payment);

    int updatePayment(Payment payment, String paymentId);

}
