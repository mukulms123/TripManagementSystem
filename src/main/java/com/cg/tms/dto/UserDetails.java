package com.cg.tms.dto;

import com.cg.tms.entities.Customer;

public class UserDetails {

	private int userId;
	private String userType;
	private String password;
	private Customer customer;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public UserDetails(int userId, String userType, String password, Customer customer) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.password = password;
		this.customer = customer;
	}
	public UserDetails(int userId, String userType, String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.password = password;
	}
	
	
}
