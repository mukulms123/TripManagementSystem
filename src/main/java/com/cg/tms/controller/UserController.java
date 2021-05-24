package com.cg.tms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.UserDetails;
import com.cg.tms.dto.UserRequest;
import com.cg.tms.entities.Admin;
import com.cg.tms.entities.User;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.service.IUserService;
import com.cg.tms.util.UserUtil;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	private IUserService uService;

	@Autowired
	private UserUtil userUtil;

	// Used for Testing
	@RequestMapping("/hello")
	public String greet() {
		return "Hello!!";
	}

	// Used for User Sign In
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/signin/{id}")
	public UserDetails userSignIn(@RequestBody @Valid UserRequest requestData, @PathVariable("id") @Min(1) int id)
			throws CustomerNotFoundException {
		User user = new User(requestData.getUserType(), requestData.getPassword());
		user.setUserId(id);
		User newUser = uService.signIn(user);
		UserDetails userDetails = userUtil.toDetailsUser(newUser);
		return userDetails;
	}

	// Used for adding new User
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public UserDetails userAdd(@RequestBody @Valid UserRequest requestData) {
		User user = new User(requestData.getUserId(), requestData.getUserType(), requestData.getPassword());
		if (user.getUserType().equalsIgnoreCase("customer")) {
			user.setCustomer(requestData.getCustomer());
		} else {
			user.setAdmin(requestData.getAdmin());
		}
		User newUser = uService.addNewUser(user);
		UserDetails userDetails = userUtil.toDetailsUser(newUser);
		return userDetails;
	}

	// Used for Sign Out
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/signout")
	public UserDetails userSignOut(@RequestBody @Valid UserRequest requestData) {
		User user = new User(requestData.getUserId(), requestData.getUserType(), requestData.getPassword());
		user.setCustomer(requestData.getCustomer());
		User userFound = uService.signOut(user);
		UserDetails userDetails = userUtil.toDetailsUser(userFound);
		return userDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/verify/{id}")
	public UserDetails userVerify( @PathVariable("id") @Min(1) int id) {
		User userFound = uService.verifyUser(id);
		UserDetails userDetails = userUtil.toDetailsUser(userFound);
		return userDetails;
	}
}
