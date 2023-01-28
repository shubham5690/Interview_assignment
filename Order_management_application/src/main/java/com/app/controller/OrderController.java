package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CustomerException;
import com.app.exception.OrderException;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService oService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> addOrderHandler(@RequestBody Order order){
		Order saveOrder=oService.addOrder(order);
		return new ResponseEntity<Order>(saveOrder, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderByIdHandler(@PathVariable Integer id) throws OrderException{
		Order getOrder=oService.findOrderById(id);
		return new ResponseEntity<Order>(getOrder, HttpStatus.OK);
	}

}
