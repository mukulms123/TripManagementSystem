package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
	public Customer viewCustomerList(int packageId)throws PackageNotFoundException, CustomerNotFoundException;
	public List<Customer> viewAllCustomers();

	
	
	
}
