package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class Order {
	@Id
	private Integer orderId;
	private Integer orderItem;
	private Integer discount;
	
	@ManyToOne
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, Integer orderItem, Integer discount, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderItem = orderItem;
		this.discount = discount;
		this.customer = customer;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Integer orderItem) {
		this.orderItem = orderItem;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
