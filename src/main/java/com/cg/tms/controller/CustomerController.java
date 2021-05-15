package com.cg.tms.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
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

	// For testing
	@RequestMapping("/hello")
	public String greet() {
		return "Hello!!";
	}

	// Used for adding customer
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public CustomerDetails addCustomer(@RequestBody @Valid createCustomerRequest requestData) {
		Customer newCustomer = new Customer(requestData.getCustomerName(), requestData.getCustomerPassword(),
				requestData.getAddress(), requestData.getMobileNo(), requestData.getEmail());
		Set<Feedback> feedbackSet = requestData.getFeedback();
		if (feedbackSet != null) {
			for (Feedback feed : feedbackSet) {
				newCustomer.addFeedback(feed);
			}
		}
		Customer newCust = cService.addCustomer(newCustomer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(newCust);
		return customerDetails;

	}

	// Used for updating customer
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public CustomerDetails updateCustomer(@RequestBody @Valid updateCustomerRequest requestData,
			@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException {
		Customer customer = new Customer(requestData.getCustomerName(), requestData.getCustomerPassword(),
				requestData.getAddress(), requestData.getMobileNo(), requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.updateCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;

	}

	// Used for deleting Customer
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public CustomerDetails deleteCustomer(@RequestBody @Valid deleteCustomerRequest requestData,
			@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException {
		Customer customer = new Customer(requestData.getCustomerName(), requestData.getCustomerPassword(),
				requestData.getAddress(), requestData.getMobileNo(), requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.deleteCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}

	// Used for viewing customer using customer ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public CustomerDetails viewCustomer(@PathVariable("id") @Min(1) int customerId) throws CustomerNotFoundException {
		Customer cust = cService.viewCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}

	// Used to view all customers using package ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/pack/{id}")
	public CustomerDetails viewCustomersList(@PathVariable("id") int id)
			throws PackageNotFoundException, CustomerNotFoundException {
		Customer cust = cService.viewCustomerList(id);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}

	// Used to view all customers
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<CustomerDetails> viewAllCustomers() {
		List<Customer> customers = cService.viewAllCustomers();
		List<CustomerDetails> customerDetails = customerUtil.toDetailsCustomer(customers);
		return customerDetails;
	}
}
