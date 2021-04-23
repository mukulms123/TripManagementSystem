package com.cg.tms.dto;

import com.cg.tms.entities.Customer;

public class UserRequest {

	private int userId;
	private String userType;
	private String password;
	
	private Customer customer;
	public int getUserId() {
		return userId;
	}
	public String getUserType() {
		return userType;
	}
	public String getPassword() {
		return password;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	
	
}
