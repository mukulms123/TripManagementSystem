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

import com.cg.tms.dto.BookingRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.service.IBookingService;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {

	@Autowired
	private IBookingService bService;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Booking!!";		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public String addBooking(@RequestBody @Valid BookingRequest requestData)
	{
		System.out.println("Adding Booking ");
		System.out.println("req data: " + requestData);
		Booking booking = bService.makeBooking(new Booking(requestData.getBookingType(),requestData.getDescription(),requestData.getBookingTitle(),requestData.getBookingDate(),requestData.getUserId()));
		
		return "Done";
	}
	
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public String cancelBooking(@PathVariable("id") @Min(1) int id) throws BookingNotFoundException
	{
		System.out.println("Delete Booking ");
		System.out.println("Booking id: " + id);
		Booking booking = bService.cancelBooking(id);
		return "Done";
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public String viewBooking(@PathVariable("id") @Min(1) int bookingId) throws BookingNotFoundException
	{
		System.out.println("View Booking ");
		System.out.println("Booking Id:"+bookingId);
		Booking book = bService.viewBooking(bookingId);
		System.out.println(book);
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public String viewBooking() 
	{
		System.out.println("View All Booking ");
		List<Booking> bookings = bService.viewAllBookings();
		System.out.println(bookings.toString());
		return null;
	}
}
