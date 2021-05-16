package com.spring.ms.cloud.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ms.cloud.entity.Payment;

import java.util.List;

public interface PaymentService {

	public Payment savePayment(Payment p) throws JsonProcessingException;

	public  Payment findByOrderId(Long orderId) throws JsonProcessingException;
}
