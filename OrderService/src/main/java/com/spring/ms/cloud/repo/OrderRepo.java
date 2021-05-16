package com.spring.ms.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ms.cloud.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Long> {

	

}
