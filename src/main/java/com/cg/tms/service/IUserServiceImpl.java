package com.cg.tms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Admin;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.UserNotFoundException;
import com.cg.tms.repository.IAdminRepository;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	// For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private IUserRepository uRep;

	@Autowired
	private ICustomerRepository cRep;

	@Autowired
	private IAdminRepository aRep;

	// Used for adding new User
	@Override
	public User addNewUser(User user) {
		if (user.getUserType().equalsIgnoreCase("customer")) {
			Customer cust = user.getCustomer();
			Customer newCust = cRep.save(cust);
			user.setUserId(newCust.getCustomerId());
		} else {
			Admin admin = user.getAdmin();
			Admin newAdmin = aRep.save(admin);
			user.setUserId(newAdmin.getAdminId());
		}

		User newUser = uRep.save(user);
		logger.info("********Adding User by Id: " + user.getUserId() + "********");
		return newUser;
	}

	// Used for signing in
	@Override
	public User signIn(User user) throws UserNotFoundException {
		Optional<User> opt = uRep.findById(user.getUserId());
		if (!opt.isPresent()) {
			throw new UserNotFoundException("User Not Found at Id: " + user.getUserId());
		}
		User newUser = opt.get();
		if(!(newUser.getUserType().equals(user.getUserType())))
		{
			throw new UserNotFoundException("User type not correct");
		}
		if(!(newUser.getPassword().equals(user.getPassword())))
		{
			throw new UserNotFoundException("Password not correct");
		}
		if(user.getUserType().equals("customer"))
		{
			Optional<Customer> optCust = cRep.findById(user.getUserId()); 
			Customer cust = optCust.get();
			newUser.setCustomer(cust);
		}
		else
		{
			Optional<Admin> optAdmin = aRep.findById(user.getUserId());
			Admin admin = optAdmin.get();
			newUser.setAdmin(admin);
		}
		logger.info("********SignIn by Id and Password: " + user.getUserId() + "  " + user.getPassword() + "********");
		return newUser;
	}

	// Used for signing out
	@Override
	public User signOut(User user) {
		Optional<User> opt = uRep.findById(user.getUserId());
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + user.getUserId());
		}
		User newUser = opt.get();
		if ((newUser.getUserId() != user.getUserId() && (newUser.getPassword().contentEquals(user.getPassword())))) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + user.getUserId());
		}
		logger.info("********SignOut by Id and Password: " + user.getUserId() + "  " + user.getPassword() + "********");
		return newUser;
	}

}
