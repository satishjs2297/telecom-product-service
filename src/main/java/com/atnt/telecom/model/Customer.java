package com.atnt.telecom.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1013479834262222490L;

	@Id
	private String customerName;

	private String password;

	private String mobileNumber;

	private String address;
	
	private List<CustomerOrder> orders;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String password, String mobileNumber, String address, List<CustomerOrder> orders) {
		this.customerName = customerName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.orders = orders;
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

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

}
