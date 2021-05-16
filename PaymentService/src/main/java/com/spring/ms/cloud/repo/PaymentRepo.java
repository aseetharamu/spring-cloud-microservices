package com.spring.ms.cloud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.ms.cloud.entity.Payment;

import java.util.List;



public interface PaymentRepo extends JpaRepository<Payment, Long> {

	 Payment findByOrderId(Long orderId);

}