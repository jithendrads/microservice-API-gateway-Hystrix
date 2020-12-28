package com.jithendra.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jithendra.orderservice.common.Payment;
import com.jithendra.orderservice.common.TransactionRequest;
import com.jithendra.orderservice.common.TransactionResponse;
import com.jithendra.orderservice.entity.Order;
import com.jithendra.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookorder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
	{
		
		//return  orderService.saveOrder(order);
		return orderService.saveOrder(request);
		//do a rest call to Payment and pass the order id
	}
	

}
