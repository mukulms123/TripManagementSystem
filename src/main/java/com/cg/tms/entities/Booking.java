package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private  LocalDate bookingDate;
//	@OneToOne
	//complete the code
//	private Package pack;
	private  int userId;
	
	

}
