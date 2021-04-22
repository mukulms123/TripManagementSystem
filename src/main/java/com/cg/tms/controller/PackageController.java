package com.cg.tms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Package1;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.service.IPackageService;

@RestController
@RequestMapping("/package")
@Validated
public class PackageController {

	@Autowired
	private IPackageService pService;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Package!!";		
	}
	
	@GetMapping("/add")
	public String addPackage()
	{
		Package1 pack = new Package1("new","age","guy",4566.7);
		pack.addBooking(new Booking("abc","hello","bookingtitle",LocalDate.now(),56));
		pService.addPackage(pack);	
		
		return "Done";
	}
	
}
