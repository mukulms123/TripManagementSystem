package com.cg.tms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String  customerPassword;
	private String address;
	private String mobileNo;
	private String email;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Feedback> feedbacks = new HashSet<>();
	
	//Parameterized constructor without feedback and Id
	public Customer(String customerName, String customerPassword, String address, String mobileNo,
			String email) {
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}


	//default constructor
	public Customer() {
	}

	//Getters and Setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Feedback> getFeedback() {
		return feedbacks;
	}


	public void setFeedback(Set<Feedback> feedback) {
		this.feedbacks = feedback;
	}
	
	public void addFeedback(Feedback feedback)
	{
		feedback.setCustomer(this);
		feedbacks.add(feedback);
	}

	public Customer(int customerId) {
		this.customerId = customerId;
	}


	//toString with Feedback
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", feedback=" + feedbacks + "]";
	}

	

	
	
	
	
	
	
	
	
	
}
