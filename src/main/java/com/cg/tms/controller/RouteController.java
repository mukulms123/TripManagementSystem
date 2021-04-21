package com.cg.tms.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Route;
import com.cg.tms.service.IRouteService;

@RestController
@RequestMapping("/route")
@Validated
public class RouteController {
	
	@Autowired
	private IRouteService rService;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from feedback";		
	}
	
	@GetMapping("/add")
	public String addFeedback()
	{
		Route route = new Route("Delhi","Kanour",LocalDateTime.now(),LocalDateTime.now(),LocalDate.now(),"Raj",23.45);
		//Added exception handling if customer is not found
		rService.addRoute(route);
		
		return "Done";
		
	}
	
}
