package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;

public class ICustomerServiceImpl implements ICustomerService{

	@Override
	public Customer addCustomer(Customer customer) {
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		return null;
	}

	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException {
		return null;
	}

	@Override
	public List<Customer> viewCustomerList(int routeId) throws RouteNotFoundException {
		return null;
	}

}
