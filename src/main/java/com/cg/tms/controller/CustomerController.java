package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	@Autowired
	private ICustomerService cService;
	
	@RequestMapping("/hello")
	public String greet() {
		System.out.println("Greeting!!");
		return "Hello!!";
	}
	
	//change the parameters and change the return type
	@GetMapping("/add")
	public String addStudent() {
	System.out.println("Adding Customer ");
		Customer customer = new Customer("rima","rim123","def","9510859887","mail2rima@gmail.com");
		Set<Feedback> feedbackSet = new HashSet<Feedback>();
		feedbackSet.add(new Feedback("Hello",3,LocalDate.now()));
		feedbackSet.add(new Feedback("Nice",4,LocalDate.now()));		
		if(feedbackSet!=null) {
			for (Feedback feed : feedbackSet) {
				customer.addFeedback(feed);
			}
		}
		Customer cust = cService.addCustomer(customer);
		//Change it to dto and return it
		return "Done";
	}
}
