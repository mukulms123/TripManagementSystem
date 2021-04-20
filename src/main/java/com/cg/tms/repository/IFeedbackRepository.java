package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;

public interface IFeedbackRepository extends JpaRepository<Feedback, String>{
	
	
//		public Feedback  addFeedback(Feedback feedback);
//		public Feedback   findByFeedbackId(int feedbackId) throws FeedbackNotFoundException;
//		public Feedback   findByCustomerId(int customerId) throws CustomerNotFoundException;
//		public List<Feedback> viewAllFeedbacks();
//	
	

}
