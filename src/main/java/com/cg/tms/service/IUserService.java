package com.cg.tms.service;

import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.UserNotFoundException;

public interface IUserService {
public  User addNewUser(User user);
public User signIn(User user) throws UserNotFoundException;
public User signOut(User user);
}
