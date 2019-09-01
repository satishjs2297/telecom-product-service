package com.atnt.telecom.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnt.telecom.dao.repository.CustomerOrderRepository;
import com.atnt.telecom.dao.repository.CustomerRepository;
import com.atnt.telecom.dao.repository.RechargePlanRepository;
import com.atnt.telecom.model.Customer;
import com.atnt.telecom.model.CustomerOrder;
import com.atnt.telecom.model.RechargePlan;

@Service
public class RechargePlanService {
	private final static Logger LOG = LoggerFactory.getLogger(RechargePlanService.class);

	private RechargePlanRepository rechargePlanRepository;

	private CustomerOrderRepository customerOrderRepository;

	private CustomerRepository customerRepository;

	@Autowired
	public RechargePlanService(RechargePlanRepository rechargePlanRepository,
			CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository) {
		this.rechargePlanRepository = rechargePlanRepository;
		this.customerOrderRepository = customerOrderRepository;
		this.customerRepository = customerRepository;
	}

	public List<RechargePlan> getAllActivePlans() {
		LOG.info("RechargePlanService begin!!");
		return rechargePlanRepository.findAll();
	}

	public Long updatePlan(RechargePlan rechargePlan) {
		rechargePlanRepository.save(rechargePlan);
		List<CustomerOrder> custOrderList = customerOrderRepository
				.getCustomerOrdersByPlanName(rechargePlan.getPlanName());

		custOrderList.forEach(custOrder -> {
			if (custOrder.getPlanName().equals(rechargePlan.getPlanName())) {
				custOrder.setValidity(rechargePlan.getValidity());
				customerOrderRepository.save(custOrder);
			}
		});

		List<Customer> customers = customerRepository.findAll();
		customers.forEach(customer -> {
			List<CustomerOrder> orders = customer.getOrders();
			orders.forEach(order -> {
				if (order.getPlanName().contentEquals(rechargePlan.getPlanName())) {
					order.setValidity(rechargePlan.getValidity());
				}
			});
			customerRepository.save(customer);
		});
		return rechargePlan.getId();
	}
}
