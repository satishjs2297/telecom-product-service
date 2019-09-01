package com.atnt.telecom.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.atnt.telecom.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer getCustomerByCustomerName(String customerName);
	
	@Query("{customer.planName : ?0}")
	public List<Customer> getCustomersByPlanName(String planName);

}
