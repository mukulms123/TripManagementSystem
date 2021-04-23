package com.cg.tms.dto;

import java.time.LocalDate;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Hotel;

public class PackageDetails {

	private int packageId; 
	private String packageName; 
	private String packageDescription;
	private String packageType;
	private double packageCost;
	
	//For Hotel
	private int hotelId;
//	private String hotelName;
//	private String hotelType;
//	private String hotelDescription;
//	private String address;
//	private double rent;
//	private String status;
	
	//For Booking
	private int bookingId;
	
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

	public PackageDetails(int packageId, String packageName, String packageDescription, String packageType,
			double packageCost) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
	}
	
	//For Hotel 
    public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
//	public String getHotelName() {
//		return hotelName;
//	}
//	public void setHotelName(String hotelName) {
//		this.hotelName = hotelName;
//	}
//	public String getHotelType() {
//		return hotelType;
//	}
//	public void setHotelType(String hotelType) {
//		this.hotelType = hotelType;
//	}
//	public String getHotelDescription() {
//		return hotelDescription;
//	}
//	public void setHotelDescription(String hotelDescription) {
//		this.hotelDescription = hotelDescription;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public double getRent() {
//		return rent;
//	}
//	public void setRent(double rent) {
//		this.rent = rent;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	//For Booking
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public String toString() {
		return "PackageDetails [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + "]";
	}
	
	
}
