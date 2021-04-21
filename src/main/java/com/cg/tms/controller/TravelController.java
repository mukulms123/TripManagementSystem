package com.cg.tms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Travels;
import com.cg.tms.repository.IBusRepository;
import com.cg.tms.service.ITravelsService;

@RestController
@RequestMapping("/travel")
@Validated
public class TravelController {

	@Autowired
	private ITravelsService tService;
	
	@Autowired
	private IBusRepository bRes;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Travel";		
	}
	
	@GetMapping("/add")
	public String addFeedback()
	{
		Travels trav = new Travels("abe","def","ghi","9810827");
		trav.addBus(new Bus("DTC","557",23));
		//Bus b = new Bus("abc","def",45);
		//bRes.save(b);		
		
		tService.addTravels(trav);
		
		return "Done";
		
	}
	
}
