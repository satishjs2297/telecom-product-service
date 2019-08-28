package com.atnt.telecom.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atnt.telecom.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer getCustomerByCustomerNameAndPassword(String customerName, String password);	
}
