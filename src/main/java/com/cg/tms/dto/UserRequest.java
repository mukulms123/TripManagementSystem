package com.cg.tms.dto;

import javax.validation.constraints.NotNull;

import com.cg.tms.entities.Customer;

public class UserRequest {

	private int userId;
	@NotNull
	private String userType;
	@NotNull
	private String password;

	private Customer customer;

	// Getters and Setters
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
