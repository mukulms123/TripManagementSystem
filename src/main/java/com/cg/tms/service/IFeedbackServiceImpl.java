package com.cg.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IFeedbackRepository;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	
	//For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private IFeedbackRepository fRep;
	
	@Autowired 
	private ICustomerRepository cRep;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback feed = fRep.save(feedback);
		logger.info("********Adding Feedback: "+feed.getFeedbackId()+"********");
		return feed;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		Optional<Feedback> optional = fRep.findById(feedbackId);
        if (!optional.isPresent()) {
            throw new FeedbackNotFoundException("Feedback Not Found at Id: "+feedbackId);
        }
        Feedback feed = optional.get();
        logger.info("********Viewing Feedback by id: "+feedbackId+"********");
		return feed;
	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		Optional<Customer> opt = cRep.findById(customerId);
        if(!opt.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found at Id:"+customerId);
        }
        Customer customer = opt.get();
        Feedback feedback = fRep.findFeedbackByCustomer(customer);
        logger.info("********Viewing Feedback by customer id: "+feedback.getFeedbackId()+"********");
        return feedback;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		List<Feedback> feedbacks = fRep.findAll();
		logger.info("********Viewing All Feedbacks: "+feedbacks+"********");
        return feedbacks;
	}


}
