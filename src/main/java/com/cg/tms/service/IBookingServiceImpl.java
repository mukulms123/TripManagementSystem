package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IBookingRepository;
import com.cg.tms.repository.IPackageRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	// For Logger
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private IBookingRepository bRep;
	
	@Autowired
	private IPackageRepository pRep;

	// Used for make Booking
	@Override
	public Booking makeBooking(Booking booking) throws PackageNotFoundException {
		Optional<Package1> opt = pRep.findById(booking.getPackId());
		if (!opt.isPresent()) {
			throw new PackageNotFoundException("Package Not Found at Package Id:" + booking.getPackId());
		}
		Package1 pack = opt.get();
		booking.setPack(pack);
		Booking book = bRep.save(booking);
		logger.info("********Adding Booking by id: " + book.getBookingId() + "********");
		return book;
	}

	// Used for cancel Booking using Booking ID
	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		Booking book = viewBooking(bookingId);
		bRep.delete(book);
		logger.info("********Cancel Booking by id: " + book.getBookingId() + "********");
		return book;
	}

	// Used for view Booking using Booking ID
	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> opt = bRep.findById(bookingId);
		if (!opt.isPresent()) {
			throw new BookingNotFoundException("Booking Not Found at ID: " + bookingId);
		}
		Booking book = opt.get();
		logger.info("********View Booking by id: " + bookingId + "********");
		return book;
	}

	// Used to view all Bookings
	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bRep.findAll();
		logger.info("********Viewing all Booking: " + bookings + "********");
		return bookings;
	}

}
