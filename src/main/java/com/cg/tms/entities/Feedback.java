package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue
	private int feedbackId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private String feedback;
	private int rating;
	private LocalDate submitDate;

	// toString without the Customer to avoid going to infinite loop
	@Override
	public String toString() {
		return "Feedback [feedback=" + feedback + ", rating=" + rating + ", submitDate=" + submitDate + "]";
	}

	// constructor without customer
	public Feedback(int feedbackId, String feedback, int rating, LocalDate submitDate) {
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}

	// constructor without Customer and Id
	public Feedback(String feedback, int rating, LocalDate submitDate) {
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}

	public Feedback() {
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

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
