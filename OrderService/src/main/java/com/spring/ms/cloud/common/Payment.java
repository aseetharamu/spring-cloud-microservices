package com.spring.ms.cloud.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// THIS CLASS IS USED AS DTO NOT ENTITY IN ORDERSERVICE PACKAGE
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

	private long id;
	private String paymentStatus;
	private String transactionId;
	private long orderId;
	private double amount;
	
}