package com.spring.ms.cloud.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ms.cloud.common.TransactionRequest;
import com.spring.ms.cloud.common.TransactionResponse;

public interface OrderService {
	
	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException;

}
