package com.spring.ms.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private long id;
	private String name;
	private int quantity;
	private double price;
	

}
