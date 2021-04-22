package com.cg.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackRepository fRep;
	
	@Autowired 
	private ICustomerService cService;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback feed = fRep.save(feedback);
		return feed;
	}

	@Override
	public Feedback findByFeedbackId(String feedbackId) throws FeedbackNotFoundException {
		Optional<Feedback> optional = fRep.findById(feedbackId);
        if (!optional.isPresent()) {
            throw new FeedbackNotFoundException();
        }
        Feedback feed = optional.get();
		return feed;
	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		Customer customer = cService.viewCustomer(customerId);
        if(customer==null){
            throw new CustomerNotFoundException();
        }
        Feedback feedback = fRep.findFeedbackByCustomer(customer);
        return feedback;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		List<Feedback> feedbacks = fRep.findAll();
        return feedbacks;
	}


}
