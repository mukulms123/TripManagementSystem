package com.cg.tms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.tms.entities.Customer;

public class createFeedbackRequest {

	private Customer customer;
	@NotNull
	@NotBlank
	private String feedback;
	@NotNull
	@NotBlank
	private int rating;
	@NotNull
	@NotBlank
	private LocalDate submitDate;

	// Getters and Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

}
