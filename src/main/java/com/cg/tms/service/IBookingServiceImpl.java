package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.repository.IBookingRepository;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bRep;
	
	@Override
	public Booking makeBooking(Booking booking) {
		Booking book = bRep.save(booking);
		return book;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		Booking book = viewBooking(bookingId);
		bRep.delete(book);
		return book;
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> opt = bRep.findById(bookingId);
		if(!opt.isPresent()){
			throw new BookingNotFoundException();
		}
		Booking book = opt.get();
		return book;
	}

	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bRep.findAll();
		return bookings;
	}

}
