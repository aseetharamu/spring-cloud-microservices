package com.spring.ms.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ms.cloud.common.TransactionRequest;
import com.spring.ms.cloud.common.TransactionResponse;
import com.spring.ms.cloud.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/save")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
		
		return orderService.saveOrder(request);
		
	}
	
}
