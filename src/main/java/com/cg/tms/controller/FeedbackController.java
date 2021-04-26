package com.cg.tms.controller;

import java.util.List;

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
import com.cg.tms.dto.FeedbackRequest;
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

	// Used for testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		System.out.println("Greeting!!");
		return "Hello from feedback!!";
	}

	// Used for adding feedback
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public FeedbackDetails addFeedback(@RequestBody @Valid FeedbackRequest requestData) {
		Feedback feed = new Feedback(requestData.getFeedback(), requestData.getRating(), requestData.getSubmitDate());
		Customer customer = requestData.getCustomer();
		if (customer != null) {
			feed.setCustomer(customer);
		}
		Feedback newFeedback = fService.addFeedback(feed);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(newFeedback);
		return details;

	}

	// Used for adding feedback for customer ID
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add/{id}")
	public FeedbackDetails addFeedback(@RequestBody @Valid FeedbackRequest requestData,
			@PathVariable("id") @Min(1) int id) {
		Feedback feed = new Feedback(requestData.getFeedback(), requestData.getRating(), requestData.getSubmitDate());
		Customer customer = new Customer(id);
		feed.setCustomer(customer);
		Feedback newFeedback = fService.addFeedback(feed);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(newFeedback);
		return details;
	}

	// Used for viewing feedback by feedback ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public FeedbackDetails getFeedbackById(@PathVariable("id") int id) throws FeedbackNotFoundException {
		Feedback feedback = fService.findByFeedbackId(id);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(feedback);
		return details;
	}

	// Used for viewing the feedback by customer ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/custview/{id}")
	public FeedbackDetails getFeedbackByCustId(@PathVariable("id") int id)
			throws FeedbackNotFoundException, CustomerNotFoundException {
		Feedback feedback = fService.findByCustomerId(id);
		FeedbackDetails details = feedbackUtil.toDetailsFeedback(feedback);
		return details;
	}

	// Used for view all Feedbacks
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<FeedbackDetails> viewAllFeedbacks() {
		List<Feedback> feedbacks = fService.viewAllFeedbacks();
		List<FeedbackDetails> details = feedbackUtil.toDetailsFeedback(feedbacks);
		return details;
	}
}
