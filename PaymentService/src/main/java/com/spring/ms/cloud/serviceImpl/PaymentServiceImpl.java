package com.spring.ms.cloud.serviceImpl;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ms.cloud.entity.Payment;
import com.spring.ms.cloud.repo.PaymentRepo;
import com.spring.ms.cloud.service.PaymentService;

import javassist.expr.NewArray;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepo paymentRepo;
	
	private Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public Payment savePayment(Payment payment) throws JsonProcessingException {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		logger.info("Payment Service request {}", new ObjectMapper().writeValueAsString(payment));
		return paymentRepo.save(payment);
	}
	
	public String paymentProcessing() {
		//api should be third party payment gateway(paypal, paytm)
		return new Random().nextBoolean()?"true":"false";
	}

	@Override
	public Payment findByOrderId(Long orderId) throws JsonProcessingException {
		Payment payment =  paymentRepo.findByOrderId(orderId);
		logger.info("Payment Service findPaymentHistoryByOrderId: {}", new ObjectMapper().writeValueAsString(payment));
			return payment;
	}

}
