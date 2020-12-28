package com.jithendra.orderservice.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	private int id;
	private String name;
	private int qty;
	private double price;

}
