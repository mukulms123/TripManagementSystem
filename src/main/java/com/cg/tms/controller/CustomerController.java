package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.createCustomerRequest;
import com.cg.tms.dto.deleteCustomerRequest;
import com.cg.tms.dto.updateCustomerRequest;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
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
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public String addCustomer(@RequestBody @Valid createCustomerRequest requestData) {
		System.out.println("Adding Customer ");
		System.out.println("req data: " + requestData);
		Customer newCustomer = cService.addCustomer(new Customer(requestData.getCustomerName(),requestData.getCustomerPassword(),requestData.getAddress(),requestData.getMobileNo(),requestData.getEmail()));
		Set<Feedback> feedbackSet = requestData.getFeedbacks();
		if(feedbackSet!=null) {
			for (Feedback feed : feedbackSet) {
				newCustomer.addFeedback(feed);
			}
		}
		System.out.println("Customer came: " + newCustomer);
		Customer newCust = cService.addCustomer(newCustomer);
		return null;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public String updateCustomer(@RequestBody @Valid updateCustomerRequest requestData,@PathVariable("id") @Min(1) int customerId ) throws CustomerNotFoundException {
		System.out.println("Updating Customer ");
		System.out.println("req data: " + requestData);
		System.out.println("Customer Id:"+customerId);
		Customer customer = new Customer(requestData.getCustomerName(),requestData.getCustomerPassword(),requestData.getAddress(),requestData.getMobileNo(),requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.updateCustomer(customer);
		return null;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@RequestBody @Valid deleteCustomerRequest requestData,@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException
	{
		System.out.println("Deleting Customer ");
		System.out.println("req data: " + requestData);
		System.out.println("Customer Id:"+customerId);
		Customer customer = new Customer(requestData.getCustomerName(),requestData.getCustomerPassword(),requestData.getAddress(),requestData.getMobileNo(),requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.deleteCustomer(customer);
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public String viewCustomer(@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException
	{
		System.out.println("Viewing Customer ");
		System.out.println("Customer Id:"+customerId);
		Customer cust = cService.viewCustomer(customerId);
		return null;
	}
}
