package com.cg.tms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository uRep;
	
	@Autowired
	private ICustomerRepository cRep; 
	
	@Override
	public User addNewUser(User user) {
		Customer cust = user.getCustomer();
		Customer newCust = cRep.save(cust);
		user.setUserId(newCust.getCustomerId());
		User newUser = uRep.save(user);
		return newUser;
	}

	@Override
	public User signIn(User user) throws CustomerNotFoundException {
		Optional<User> opt = uRep.findById(user.getUserId());
		if(!opt.isPresent())
		{
			throw new CustomerNotFoundException("Customer Not Found at Id: "+user.getUserId());
		}
		User newUser = opt.get();
		if((newUser.getUserId() != user.getUserId() && (newUser.getPassword().contentEquals(user.getPassword()))))
		{
			throw new CustomerNotFoundException("Customer Not Found at Id: "+user.getUserId());
		}
		return newUser;
	}

	@Override
	public String signOut(User user) {
		return "Thank you!! Have a Good Day!!";
	}

}
