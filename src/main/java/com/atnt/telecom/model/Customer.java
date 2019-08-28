package com.atnt.telecom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1013479834262222490L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false, length = 20)
	private Long id;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "ADDRESS")
	private String address;

	// @OneToMany(cascade = CascadeType.ALL)
	// private List<CustomerOrder> orders;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String password, String mobileNumber, String address) {
		this.customerName = customerName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
