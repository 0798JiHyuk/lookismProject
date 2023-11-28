package org.ict.lookism.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.common.Paging;
import org.ict.lookism.payment.entity.Payment;
import org.ict.lookism.payment.repository.PaymentRepository;
import org.ict.lookism.payment.repository.PaymentRepositoryCustom;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentRepositoryCustom paymentRepositoryCustom;
	
    public int selectListCount(String userId){
        return 0;
    }

    public List<Payment> selectList(Paging paging, String userId){
        return null;
    }

    public int insertPayment(Payment payment){
        return 0;
    }

    public int updatePayment(Payment payment, String paymentId){
        return 0;
    }

}
