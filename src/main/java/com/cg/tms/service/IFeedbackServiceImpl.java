package com.cg.tms.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackRepository fRes;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback feed = fRes.save(feedback);
		//change the return type to feed
		return null;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		// TODO Auto-generated method stub
		return null;
	}


}
