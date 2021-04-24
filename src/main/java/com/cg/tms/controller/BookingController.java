package com.cg.tms.controller;

import java.time.LocalDate;
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
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.CustomerNotFoundException;
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
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Booking!!";		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add/{id}")
	public BookingDetails addBooking(@RequestBody @Valid BookingRequest requestData,@PathVariable("id") @Min(1) int id)
	{
		System.out.println("Adding Booking ");
		System.out.println("req data: " + requestData);
		System.out.println("Id:"+id);
		Booking book = new Booking(requestData.getBookingType(),requestData.getDescription(),requestData.getBookingTitle(),requestData.getBookingDate(),requestData.getUserId());
		book.setUserId(id);
		Booking booking = bService.makeBooking(book);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(booking);
		return bookingDetails;
	}
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public BookingDetails cancelBooking(@PathVariable("id") @Min(1) int id) throws BookingNotFoundException
	{
		System.out.println("Delete Booking ");
		System.out.println("Booking id: " + id);
		Booking booking = bService.cancelBooking(id);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(booking);
		return bookingDetails;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public BookingDetails viewBooking(@PathVariable("id") @Min(1) int bookingId) throws BookingNotFoundException
	{
		System.out.println("View Booking ");
		System.out.println("Booking Id:"+bookingId);
		Booking book = bService.viewBooking(bookingId);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(book);
		return bookingDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<BookingDetails> viewBooking() 
	{
		System.out.println("View All Booking ");
		List<Booking> bookings = bService.viewAllBookings();
		System.out.println(bookings.toString());
		List<BookingDetails> bookingDetails = bookingUtil.toDetailsBooking(bookings);
		return bookingDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add/{id}/{packId}")
	public BookingDetails addBooking(@RequestBody @Valid BookingRequest requestData,@PathVariable("id") @Min(1) int id,@PathVariable("packId") @Min(1) int packId)
	{
		System.out.println("Adding Booking ");
		System.out.println("req data: " + requestData);
		System.out.println("Id:"+id);
		System.out.println("Pack Id:"+packId);
		Booking book = new Booking(requestData.getBookingType(),requestData.getDescription(),requestData.getBookingTitle(),requestData.getBookingDate(),requestData.getUserId());
		book.setUserId(id);
		book.setPack(new Package1(packId));
		
		Booking booking = bService.makeBooking(book);
		BookingDetails bookingDetails = bookingUtil.toDetailsBooking(booking);
		return bookingDetails;
	}
}
