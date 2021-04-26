package com.cg.tms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	private int userId;
	private String userType;
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
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

	public User(int userId, String userType, String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.password = password;
	}

	public User(String userType, String password) {
		super();
		this.userType = userType;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", password=" + password + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User() {
	}

	public void addCustomer(Customer customer) {
		this.setUserId(customer.getCustomerId());
		this.setPassword(customer.getCustomerPassword());
		this.setUserType("customer");
	}

}
