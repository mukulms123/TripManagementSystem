package com.cg.tms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BookingRequest {

	@NotBlank @Size(min = 2, max = 50)
	private String bookingType;
	@NotBlank @Size(min = 2, max = 50)
	private String description;
	@NotBlank @Size(min = 2, max = 50)
	private String bookingTitle;
	@NotBlank @Size(min = 2, max = 50)
	private  LocalDate bookingDate;
	private  int userId;
	
	public String getBookingType() {
		return bookingType;
	}
	public String getDescription() {
		return description;
	}
	public String getBookingTitle() {
		return bookingTitle;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "createBookingRequest [bookingType=" + bookingType + ", description=" + description + ", bookingTitle="
				+ bookingTitle + ", bookingDate=" + bookingDate + "]";
	}
	
	private String bookingId;

	public String getBookingId() {
		return bookingId;
	}
	
		
}
