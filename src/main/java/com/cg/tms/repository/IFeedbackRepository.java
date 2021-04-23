package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;


@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer>{

		Feedback findFeedbackByCustomer(Customer customer);
	
	
//		public Feedback  addFeedback(Feedback feedback);
//		public Feedback   findByFeedbackId(int feedbackId) throws FeedbackNotFoundException;
//		public Feedback   findByCustomerId(int customerId) throws CustomerNotFoundException;
//		public List<Feedback> viewAllFeedbacks();
//	
	

}
