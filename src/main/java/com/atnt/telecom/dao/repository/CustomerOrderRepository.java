package com.atnt.telecom.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.atnt.telecom.model.CustomerOrder;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, Long> {

	@Query("{planName : ?0}")
	public List<CustomerOrder> getCustomerOrdersByPlanName(String planName);
}
