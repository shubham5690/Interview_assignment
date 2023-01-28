package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomerException;
import com.app.exception.OrderException;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo oRepo;
	
	public Order addOrder(Order order) {
		return oRepo.save(order);
	}
	
	public Order findOrderById(Integer id) throws OrderException{
		Optional<Order> opt=oRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new OrderException("order not found by this id= "+id);
		}
	}
}
