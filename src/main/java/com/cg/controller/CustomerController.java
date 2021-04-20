package com.cg.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.service.ICustomerService;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

	
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
}
