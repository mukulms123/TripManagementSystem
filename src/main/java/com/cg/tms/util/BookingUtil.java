package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.BookingDetails;
import com.cg.tms.entities.Booking;

@Component
public class BookingUtil {

	public BookingDetails toDetailsBooking(Booking book)
	{
		BookingDetails bookingDetails = new BookingDetails(book.getBookingId(),book.getBookingType(),book.getDescription(),book.getBookingTitle(),book.getBookingDate());
		return bookingDetails;
	}
	
	public List<BookingDetails> toDetailsBooking(Collection<Booking> book)
	{
		List<BookingDetails> bookingList = new ArrayList<>();
		for (Booking boo : book) {
			BookingDetails bookingDetails = toDetailsBooking(boo);
			bookingList.add(bookingDetails);
		}
		return bookingList;
	}
}
