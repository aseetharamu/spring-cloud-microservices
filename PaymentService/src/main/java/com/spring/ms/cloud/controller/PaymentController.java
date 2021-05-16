package com.spring.ms.cloud.controller;

import org.hibernate.query.criteria.LiteralHandlingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ms.cloud.entity.Payment;
import com.spring.ms.cloud.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
@Autowired	
PaymentService paymentService;

	@PostMapping("/save")
	public Payment savepayment(@RequestBody Payment payment) throws JsonProcessingException {
		return paymentService.savePayment(payment);
	}
	
	@GetMapping("/history/{orderId}")
	public Payment findPaymentHistorybyOrederId(@PathVariable Long orderId) throws JsonProcessingException {
		return paymentService.findByOrderId(orderId);
		
	}

}
