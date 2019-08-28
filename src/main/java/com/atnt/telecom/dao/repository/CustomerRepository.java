package com.atnt.telecom.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atnt.telecom.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer getCustomerByCustomerName(String customerName);
}
