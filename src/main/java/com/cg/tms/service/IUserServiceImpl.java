package com.cg.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.User;
import com.cg.tms.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository uRes;
	
	@Override
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
