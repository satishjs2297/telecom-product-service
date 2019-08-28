package com.atnt.telecom.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atnt.telecom.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

}
