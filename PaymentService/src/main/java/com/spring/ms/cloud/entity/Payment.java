package com.spring.ms.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

	@Id
	@GeneratedValue
	private long id;
	private String paymentStatus;
	private String transactionId;
	private long orderId;
	private double amount;
	
}
