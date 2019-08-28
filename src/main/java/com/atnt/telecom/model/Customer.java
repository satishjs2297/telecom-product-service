package com.atnt.telecom.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1013479834262222490L;

	@Id
	private String customerName;

	private String password;

	private String mobileNumber;

	private String address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String password, String mobileNumber, String address) {
		this.customerName = customerName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
