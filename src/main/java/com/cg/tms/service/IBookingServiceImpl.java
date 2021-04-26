package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.repository.IBookingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	//For Logger
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);
	
	@Autowired
	private IBookingRepository bRep;
	
	@Override
	public Booking makeBooking(Booking booking) {
		Booking book = bRep.save(booking);
		logger.info("********Adding Booking by id: "+book.getBookingId()+"********");
		return book;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		Booking book = viewBooking(bookingId);
		bRep.delete(book);
		logger.info("********Cancel Booking by id: "+book.getBookingId()+"********");
		return book;
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> opt = bRep.findById(bookingId);
		if(!opt.isPresent()){
			throw new BookingNotFoundException("Booking Not Found at ID: "+bookingId);
		}
		Booking book = opt.get();
		logger.info("********View Booking by id: "+bookingId+"********");
		return book;
	}

	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bRep.viewAllBookings();
//		List<Booking> bookings = bRep.findAll();
		logger.info("********Viewing all Booking: "+bookings+"********");
		return bookings;
	}

}
