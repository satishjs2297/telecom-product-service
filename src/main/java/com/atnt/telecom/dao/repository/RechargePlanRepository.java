package com.atnt.telecom.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atnt.telecom.model.RechargePlan;

public interface RechargePlanRepository  extends MongoRepository<RechargePlan, Long> {

}
