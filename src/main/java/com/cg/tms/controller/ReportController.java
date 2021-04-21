package com.cg.tms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Report;
import com.cg.tms.service.IFeedbackService;
import com.cg.tms.service.IReportService;

@RestController
@RequestMapping("/report")
@Validated
public class ReportController {

	@Autowired
	private IReportService rService;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from feedback";		
	}
	
//	@GetMapping("/add")
//	public String addFeedback()
//	{
//		Report rept = new Report("report1","evaluation");
//		rService.addReport(rept);
//		
//		return "Done";
//		
//	}
}
