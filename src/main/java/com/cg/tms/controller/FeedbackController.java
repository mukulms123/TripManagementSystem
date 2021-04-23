package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.cg.tms.dto.FeedbackDetails;
import com.cg.tms.dto.createCustomerRequest;
import com.cg.tms.dto.createFeedbackRequest;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.service.IFeedbackService;
import com.cg.tms.util.FeedbackUtil;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private IFeedbackService fService;
	
	@Autowired
	private FeedbackUtil feedbackUtil;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from feedback!!";		
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public FeedbackDetails addCustomer(@RequestBody @Valid createFeedbackRequest requestData) {
		System.out.println("Adding Feedback ");
		System.out.println("req data: " + requestData);
		Feedback feed = new Feedback(requestData.getFeedback(),requestData.getRating(),requestData.getSubmitDate());
		Customer customer = requestData.getCustomer();
		if(customer!=null) {
			feed.setCustomer(customer);
		}
		Feedback newFeedback = fService.addFeedback(feed);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(newFeedback);
        return details;
		
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add/{id}")
	public FeedbackDetails addCustomer(@RequestBody @Valid createFeedbackRequest requestData,@PathVariable("id") @Min(1) int id) {
		System.out.println("Adding Feedback ");
		System.out.println("req data: " + requestData);
		Feedback feed = new Feedback(requestData.getFeedback(),requestData.getRating(),requestData.getSubmitDate());
		Customer customer = new Customer(id);
		System.out.println("Customer_id:"+customer.getCustomerId());
		feed.setCustomer(customer);
		
		Feedback newFeedback = fService.addFeedback(feed);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(newFeedback);
        return details;	
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
    public FeedbackDetails getFeedbackById(@PathVariable("id") int id) throws FeedbackNotFoundException {
		System.out.println("Finding Feedback ");
		System.out.println("Feedback ID: " + id);
        Feedback feedback = fService.findByFeedbackId(id);
        FeedbackDetails details = feedbackUtil.toDetailsFeedback(feedback);
        return details;
    } 
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/custview/{id}")
    public FeedbackDetails getFeedbackByCustId(@PathVariable("id") int id) throws FeedbackNotFoundException, CustomerNotFoundException {
		System.out.println("Finding Feedback ");
		System.out.println("Feedback ID: " + id);
        Feedback feedback = fService.findByCustomerId(id);
        System.out.println(feedback);
        FeedbackDetails details = feedbackUtil.toDetailsFeedback(feedback);
        return details;
    } 
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<FeedbackDetails> viewAllFeedbacks()
	{
		System.out.println("Viewing all Feedbacks ");
		List<Feedback> feedbacks = fService.viewAllFeedbacks();
		System.out.println(feedbacks);
		List<FeedbackDetails> details = feedbackUtil.toDetailsFeedback(feedbacks);
        return details;
	}
}
