package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomerException;
import com.app.model.Customer;
import com.app.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo cRepo;
	
	public Customer addCustomer(Customer customer) {
		return cRepo.save(customer);
	}
	
	public Customer findCustomerById(Integer id) throws CustomerException{
		Optional<Customer> opt=cRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CustomerException("customer not found by this id= "+id);
		}
	}

}
