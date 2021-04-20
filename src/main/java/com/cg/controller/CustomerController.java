package com.cg.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

//	@Autowired
//	private ICustomerService cService;
	
	@GetMapping("/hello")
	public String hello()
	{
		System.out.println("Calling Hello!!");
		return "hello";
	}
	
//	@ResponseStatus(code = HttpStatus.CREATED)
//	@GetMapping("/add")
//	public String addCustomer() {
//		System.out.println("Adding to Database");
//		Customer customer = new Customer("Nandita","nan123","Abc","981082455","mail2nanditarao@gmail.com");
//		Set<Feedback> feedbackSet = null;
//		if(feedbackSet!=null) {
//			for (Feedback feed : feedbackSet) {
//				customer.addFeedback(feed);
//			}
//		}
//		cService.addCustomer(new Customer("Nandita","nan123","Abc","981082455","mail2nanditarao@gmail.com"));
//		return "Done!!";
//		}
}
