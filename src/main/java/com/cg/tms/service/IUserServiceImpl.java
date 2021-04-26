package com.cg.tms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.dto.UserDetails;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
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

	// Used for adding new User
	@Override
	public User addNewUser(User user) {
		Customer cust = user.getCustomer();
		Customer newCust = cRep.save(cust);
		user.setUserId(newCust.getCustomerId());
		User newUser = uRep.save(user);
		logger.info("********Adding User by Id: " + user.getUserId() + "********");
		return newUser;
	}

	// Used for signing in
	@Override
	public User signIn(User user) throws CustomerNotFoundException {
		Optional<User> opt = uRep.findById(user.getUserId());
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + user.getUserId());
		}
		User newUser = opt.get();
		if ((newUser.getUserId() != user.getUserId() && (newUser.getPassword().contentEquals(user.getPassword())))) {
			throw new CustomerNotFoundException("Customer Not Found at Id: " + user.getUserId());
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
