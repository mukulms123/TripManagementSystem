package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.ReportDetails;
import com.cg.tms.dto.ReportRequest;
import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.service.IReportService;
import com.cg.tms.util.ReportUtil;

@RestController
@RequestMapping("/report")
@Validated
public class ReportController {
	
	@Autowired
	private IReportService rService;
	
	@Autowired 
	private ReportUtil reportUtil;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Report";		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public ReportDetails addReport(@RequestBody @Valid ReportRequest requestData)
	{
		System.out.println("Adding Report");
		Report report = rService.addReport(new Report(requestData.getReportName(),requestData.getReportType()));
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public ReportDetails deleteReport(@PathVariable("id") @Min(1) int id) throws ReportNotFoundException
	{
		System.out.println("Deleting Report");
		System.out.println("Report Id:"+id);
		Report report = rService.deleteReport(id);
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public ReportDetails viewReport(@PathVariable("id") @Min(1) int id) throws ReportNotFoundException
	{
		System.out.println("View Report");
		System.out.println("Report Id:"+id);
		Report report = rService.viewReport(id);
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<ReportDetails> viewAllReport()
	{
		System.out.println("View All Report");
		List<Report> reports = rService.viewAllReports();
		System.out.println("Report:"+reports);
		List<ReportDetails> rep = reportUtil.toDetailsReport(reports);
		return rep;
	}

}
