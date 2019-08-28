package com.atnt.telecom.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atnt.telecom.dao.repository.RechargePlanRepository;
import com.atnt.telecom.model.RechargePlan;

@Service
public class RechargePlanService {
	private final static Logger LOG = LoggerFactory.getLogger(RechargePlanService.class);
	
	private RechargePlanRepository rechargePlanRepository;
	
	@Autowired
	public RechargePlanService(RechargePlanRepository rechargePlanRepository) {
		this.rechargePlanRepository = rechargePlanRepository;
	}
	
	public List<RechargePlan> getAllActivePlans() {
		LOG.info("RechargePlanService begin!!");
		return rechargePlanRepository.findAll();
	}
}
