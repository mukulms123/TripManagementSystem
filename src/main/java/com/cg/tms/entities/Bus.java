package com.cg.tms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue
	private int busId;
	private String busType;
	private String busNumber;
	private int capacity;
	@OneToOne
	@JoinColumn(name = "travel_id")
	private Travels travel;

	// Constructor without Id and Travel
	public Bus(String busType, String busNumber, int capacity) {
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
	}

	// Constructor without Travel
	public Bus(int busId, String busType, String busNumber, int capacity) {
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
	}

	// Getters and setters
	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Travels getTravel() {
		return travel;
	}

	public void setTravel(Travels travel) {
		this.travel = travel;
	}

	// toString without travel
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ "]";
	}

}
