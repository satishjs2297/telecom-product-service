package com.atnt.telecom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atnt.telecom.model.RechargePlan;
import com.atnt.telecom.service.RechargePlanService;

@RestController
@RequestMapping("/recharge")
public class RechargePlanController {
	private final static Logger LOG = LoggerFactory.getLogger(RechargePlanController.class);

	private RechargePlanService rechargePlanService;
	
	@Autowired
	public RechargePlanController(RechargePlanService rechargePlanService) {
		this.rechargePlanService = rechargePlanService;
	}
	
	@GetMapping("/allActivePlans")
	public List<RechargePlan> getAllActivePlans() {
		LOG.info("getAllActivePlans begin..");
		return rechargePlanService.getAllActivePlans();
	}
}
