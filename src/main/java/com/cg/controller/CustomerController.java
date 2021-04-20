package com.cg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/hello")
	public String greet() {
		System.out.println("Greeting!!");
		return "Hello!!";
	}
}
