package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;

public class IFeedbackServiceImpl implements IFeedbackService {

	@Override
	public Feedback addFeedback(Feedback feedback) {
		return null;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		return null;
	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		return null;
	}

}
