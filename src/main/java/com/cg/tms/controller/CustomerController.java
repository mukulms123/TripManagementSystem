package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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

import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.createCustomerRequest;
import com.cg.tms.dto.deleteCustomerRequest;
import com.cg.tms.dto.updateCustomerRequest;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.util.CustomerUtil;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	@Autowired
	private ICustomerService cService;
	
	@Autowired
	private CustomerUtil customerUtil;
	
	@RequestMapping("/hello")
	public String greet() {
		System.out.println("Greeting!!");
		return "Hello!!";
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public CustomerDetails addCustomer(@RequestBody @Valid createCustomerRequest requestData) {
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
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(newCust);
		return customerDetails;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public CustomerDetails updateCustomer(@RequestBody @Valid updateCustomerRequest requestData,@PathVariable("id") @Min(1) int customerId ) throws CustomerNotFoundException {
		System.out.println("Updating Customer ");
		System.out.println("req data: " + requestData);
		System.out.println("Customer Id:"+customerId);
		Customer customer = new Customer(requestData.getCustomerName(),requestData.getCustomerPassword(),requestData.getAddress(),requestData.getMobileNo(),requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.updateCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public CustomerDetails deleteCustomer(@RequestBody @Valid deleteCustomerRequest requestData,@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException
	{
		System.out.println("Deleting Customer ");
		System.out.println("req data: " + requestData);
		System.out.println("Customer Id:"+customerId);
		Customer customer = new Customer(requestData.getCustomerName(),requestData.getCustomerPassword(),requestData.getAddress(),requestData.getMobileNo(),requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.deleteCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public CustomerDetails viewCustomer(@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException
	{
		System.out.println("Viewing Customer ");
		System.out.println("Customer Id:"+customerId);
		Customer cust = cService.viewCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all/{packId}")
	public List<CustomerDetails> ViewAllCustomers(@PathVariable("packId") int packId) throws PackageNotFoundException
	{
		System.out.println("Viewing Customer by Package ");
		System.out.println("Package Id:"+packId);
		List<Customer> cust = cService.viewAllCustomers(packId);
		System.out.println(cust);
		List<CustomerDetails> customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}
}
