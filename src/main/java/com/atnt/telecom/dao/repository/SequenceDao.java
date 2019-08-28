package com.atnt.telecom.dao.repository;

public interface SequenceDao {

	long getNextSequenceId(String key);

}