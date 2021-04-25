package com.cg.tms.repository;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>{
	
	
//	public  Booking  makeBooking(Booking booking);
	
//	@Query(" from Booking booking where booking.bookingId = :bookingId")
//	public  Booking  cancelBooking(@Param("bookingId") int bookingId) throws BookingNotFoundException;
//	
//	@Query(" from Booking booking where booking.bookingId = :bookingId")
//	public  Optional<Booking>  viewBooking(@Param("bookingId") int bookingId);
	
	@Query(" from Booking booking ")
	public List<Booking> viewAllBookings();
	
	

	

}
