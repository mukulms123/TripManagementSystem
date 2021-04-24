package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>{
	
	
//	public  Booking  makeBooking(Booking booking);
//	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
//	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
//	public List<Booking> viewAllBookings();
	
	

	

}
