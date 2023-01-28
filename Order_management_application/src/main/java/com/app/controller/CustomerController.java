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
import com.app.model.Customer;
import com.app.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer){
		Customer saveCustomer=cService.addCustomer(customer);
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable Integer id) throws CustomerException{
		Customer getCustomer=cService.findCustomerById(id);
		return new ResponseEntity<Customer>(getCustomer, HttpStatus.OK);
	}

}
