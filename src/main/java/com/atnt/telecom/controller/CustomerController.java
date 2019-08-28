package com.atnt.telecom.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atnt.telecom.model.Customer;
import com.atnt.telecom.model.CustomerOrder;
import com.atnt.telecom.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private final static Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerRegistrationService) {
		this.customerService = customerRegistrationService;
	}

	@GetMapping("/login/{userName}/{password}")
	public Boolean authenticateUser(@PathVariable String userName, @PathVariable String password) {
		return customerService.isValidUser(userName, password);
	}

	@PostMapping("/register")
	public Long registerCustomer(@RequestBody Customer customer) {
		LOG.info("Customer was successfully registered ::Customer Name {}", customer.getCustomerName());
		return customerService.registerCustomer(customer);
	}

	@PostMapping("/activateOrder/{customerId}")
	public Long activateCustomerOrder(@PathVariable Long customerId, @RequestBody CustomerOrder order) {
		LOG.info("Customer Order was successfully registered ::Customer Name {}", customerId);
		return customerService.activateCustomerOrder(customerId, Collections.singletonList(order));
	}

}
