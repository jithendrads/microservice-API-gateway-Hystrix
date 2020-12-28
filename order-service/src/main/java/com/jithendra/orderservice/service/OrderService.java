package com.jithendra.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jithendra.orderservice.common.Payment;
import com.jithendra.orderservice.common.TransactionRequest;
import com.jithendra.orderservice.common.TransactionResponse;
import com.jithendra.orderservice.entity.Order;
import com.jithendra.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String response="";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//Rest call to Payment api
		Payment paymentResponse=restTemplate.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class);
		orderRepository.save(order);
		
	   response= paymentResponse.getPaymentStatus().equals("success")? "Payment processing successful and order placed":"there is a failure in payment api, order added to cart";
			
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}
}
