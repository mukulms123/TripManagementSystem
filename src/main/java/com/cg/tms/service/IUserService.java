package com.cg.tms.service;

import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;

public interface IUserService {
public  User addNewUser(User user);
public User signIn(User user) throws CustomerNotFoundException;
public String signOut(User user);
}
