package com.cg.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.BookingDetails;
import com.cg.tms.dto.BookingRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.IBookingService;
import com.cg.tms.util.BookingUtil;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {

	@Autowired
	private IBookingService bService;

	@Autowired
	private BookingUtil bookingUtil;

	// Used for Testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from Booking!!";
	}

	// Used for Add Booking to the corresponding ID
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add/{id}")
	public BookingDetails addBooking(@RequestBody @Valid BookingRequest requestData,
			@PathVariable("id") @Min(1) int id) throws PackageNotFoundException {

		Booking book = new Booking(requestData.getBookingType(), requestData.getDescription(),
				requestData.getBookingTitle(), requestData.getBookingDate(), requestData.getUserId());
		book.setUserId(id);
		book.setPackId(requestData.getPackageId());
		Booking booking = bService.makeBooking(book);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(booking);
		return bookingDetails;
	}

	// Used for Cancel the Booking
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public BookingDetails cancelBooking(@PathVariable("id") @Min(1) int id) throws BookingNotFoundException {
		Booking booking = bService.cancelBooking(id);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(booking);
		return bookingDetails;

	}

	// Used for View Booking
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public BookingDetails viewBooking(@PathVariable("id") @Min(1) int bookingId) throws BookingNotFoundException {
		Booking book = bService.viewBooking(bookingId);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(book);
		return bookingDetails;
	}

	// Used for view all Bookings
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<BookingDetails> viewBooking() {
		List<Booking> bookings = bService.viewAllBookings();
		List<BookingDetails> bookingDetails = bookingUtil.toDetailsBooking(bookings);
		return bookingDetails;
	}
}
