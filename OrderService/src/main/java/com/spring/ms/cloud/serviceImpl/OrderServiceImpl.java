package com.spring.ms.cloud.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ms.cloud.common.Payment;
import com.spring.ms.cloud.common.TransactionRequest;
import com.spring.ms.cloud.common.TransactionResponse;
import com.spring.ms.cloud.entity.Order;
import com.spring.ms.cloud.repo.OrderRepo;
import com.spring.ms.cloud.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderServiceImpl implements OrderService{
	 	 
	@Autowired
	private OrderRepo orderRepo;

	//First inject the bean in Application class and then Autowire
	@Autowired
	@Lazy
	private RestTemplate template;
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;
	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
		
		//do a rest call to the payment api and pass order id
		String thirdPartyResponse = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		logger.info("OrderService request: {}", new ObjectMapper().writeValueAsString(request));
		//rest call
		//After eureka registry no need of url
		Payment paymentResponse = template.postForObject(ENDPOINT_URL, payment, Payment.class);
		thirdPartyResponse = paymentResponse.getPaymentStatus().equals("true")? "Payment processed and order is placed" : "Could not process the payment";
		logger.info("Payment Service response from OrderService rest call: {}", new ObjectMapper().writeValueAsString(thirdPartyResponse));
		orderRepo.save(order);
		return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), thirdPartyResponse);
	}
}
