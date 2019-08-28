package com.atnt.telecom.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atnt.telecom.model.CustomerOrder;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, Long> {

}
