package com.cg.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private IFeedbackService fService;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from feedback";		
	}
	
	@GetMapping("/add")
	public String addFeedback()
	{
		return "Done";
		
	}
}
