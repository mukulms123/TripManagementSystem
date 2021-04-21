package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.repository.IBookingRepository;

public class IBookingServiceImpl implements IBookingService {

	//create res object
	
	@Override
	public Booking makeBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

}
