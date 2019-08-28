package com.atnt.telecom.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atnt.telecom.constants.AppConstants;
import com.atnt.telecom.dao.repository.CustomerOrderRepository;
import com.atnt.telecom.dao.repository.CustomerRepository;
import com.atnt.telecom.model.Customer;
import com.atnt.telecom.model.CustomerOrder;

@Service
public class CustomerService {
	private final static Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	private CustomerRepository customerRepository;
	private CustomerOrderRepository customerOrderRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository) {
		this.customerRepository = customerRepository;
		this.customerOrderRepository = customerOrderRepository;
	}

	public boolean isValidUser(String userName, String password) {
		LOG.info("is validuser :: ");
		Customer customer = customerRepository.getCustomerByCustomerName(userName);

		return Objects.nonNull(customer) && passwordEncoder.matches(password, customer.getPassword());
	}

	public Long registerCustomer(Customer customer) {
		String encryptedPwd = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encryptedPwd);
		customer = customerRepository.save(customer);
		return customer.getId();
	}

	public Long activateCustomerOrder(Long customerId, List<CustomerOrder> orders) {
		Optional<Customer> option = customerRepository.findById(customerId);
		if (option.isPresent()) {
			orders.forEach(order -> order.setCustomerId(customerId));
			List<CustomerOrder> custOrders = customerOrderRepository.saveAll(orders);
			LOG.info("Customer found With id :: {}, Orders :: {}", customerId, custOrders);
		} else {
			throw new IllegalStateException("Customer Not found with Id ::" + customerId);
		}

		return customerId;
	}

}
