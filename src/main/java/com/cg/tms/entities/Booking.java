package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue
	private int bookingId;
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDate bookingDate;
	private int packId;
	private int userId;

	@OneToOne(cascade = CascadeType.ALL)
	private Package1 pack;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Package1 getPack() {
		return pack;
	}

	public void setPack(Package1 pack) {
		this.pack = pack;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Booking() {
	}

	public Booking(String bookingType, String description, String bookingTitle, LocalDate bookingDate, int userId) {
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description=" + description
				+ ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", userId=" + userId + "]\n";
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

}
