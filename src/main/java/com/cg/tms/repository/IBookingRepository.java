package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.BookingNotFoundException;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>{
	
	
//	public  Booking  makeBooking(Booking booking);
//	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
//	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
//	public List<Booking> viewAllBookings();
	
	
	
	
	

}
