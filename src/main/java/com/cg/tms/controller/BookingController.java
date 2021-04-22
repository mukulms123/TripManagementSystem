package com.cg.tms.controller;

import java.time.LocalDate
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Booking;
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
	
	@GetMapping("/add")
	public String addFeedback()
	{
		Booking book = new Booking("niceType","yo","nicehe",LocalDate.now(),45);
		bService.makeBooking(book);
		
		return "Done";
	}
}
