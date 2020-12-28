package com.jithendra.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jithendra.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	//Order save(Order order);

}
