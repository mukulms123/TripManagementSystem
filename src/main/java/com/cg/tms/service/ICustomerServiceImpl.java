package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.ICustomerRepository;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository cRes;
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = cRes.save(customer);
		return cust;
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
