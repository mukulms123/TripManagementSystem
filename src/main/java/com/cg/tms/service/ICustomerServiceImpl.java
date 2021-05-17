package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package1;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.repository.IUserRepository;

import org.checkerframework.checker.nullness.Opt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService {

	// For Logging
	private Logger logger = LoggerFactory.getLogger(ICustomerServiceImpl.class);

	@Autowired
	private ICustomerRepository cRep;

	@Autowired
	private IPackageRepository pRep;

	@Autowired
	private IUserRepository uRep;

	// Used for adding Customer
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = cRep.save(customer);
		User user = new User();
		user.addCustomer(cust);
		User newUser = uRep.save(user);
		logger.info("********Adding Customer by id: " + cust.getCustomerId() + "********");
		return cust;
	}

	// Used for update Customer
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		boolean check = cRep.existsById(customer.getCustomerId());
		if (!check) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + customer.getCustomerId());
		}
		Customer cust = cRep.save(customer);
		logger.info("********Updating Customer by id: " + customer.getCustomerId() + "********");
		return cust;
	}

	// Used for Deleting Customer
	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Customer cust = viewCustomer(customer.getCustomerId());
		cRep.delete(cust);
		logger.info("********Deleting Customer by id: " + cust.getCustomerId() + "********");
		return cust;
	}

	// Used to Viewing Customer using Customer ID
	@Override
	public Customer viewCustomer(int custId) throws CustomerNotFoundException {
		Optional<Customer> opt = cRep.findById(custId);
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + custId);
		}
		Customer cust = opt.get();
		logger.info("********View Customer by id: " + custId + "********");
		return cust;
	}

	// Used for viewing Customer using package ID
	@Override
	public Customer viewCustomerList(int id) throws PackageNotFoundException, CustomerNotFoundException {
		Optional<Package1> opt = pRep.findById(id);
		if (!opt.isPresent()) {
			throw new PackageNotFoundException("Package is not Found at Id:" + id);
		}
		Package1 pack = opt.get();
		int packId = cRep.findByPackage(pack);
		Optional<Customer> opt1 = cRep.findById(packId);
		if (!opt1.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found at Package Id: " + id);
		}
		Customer cust = opt1.get();
		logger.info("********View Customer by Package id: " + id + "********");
		return cust;
	}

	// Used for Viewing all Customers
	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> customers = cRep.findAll();
		logger.info("********Viewing all Customer: " + customers + "********");
		return customers;
	}

}
