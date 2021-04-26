package com.cg.tms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "package")
public class Package1 {

	@Id
	@GeneratedValue
	private int packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;

	@OneToOne
	@JoinColumn(name = "payment_id")
	private PaymentDetails payment;
	@OneToOne
	@JoinColumn(name = "ticket_id")
	private TicketDetails ticket;

	@OneToOne(cascade = CascadeType.ALL)
	private Hotel hotel;

	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;

	// Getter and setter for Payment
	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	// Getters and Setters for hotel
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	// constructor without id
	public Package1(String packageName, String packageDescription, String packageType, double packageCost) {
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
	}

	public Package1() {
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", Booking="
				+ booking + "]";
	}

	// Getters and Setters
	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	// Getter and Setters for ticket
	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}

	// Getters and Setters for booking
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	// addBooking method
	public void addBooking(Booking booking) {
		booking.setPack(this);
		// Made changes here 111111
		booking.setPackId(this.packageId);
		this.setBooking(booking);
	}

	// To add Hotel method
	public void addHotel(Hotel hot) {
		hot.setPack(this);
		this.setHotel(hot);
	}

	public Package1(int packageId) {
		this.packageId = packageId;
	}

}
