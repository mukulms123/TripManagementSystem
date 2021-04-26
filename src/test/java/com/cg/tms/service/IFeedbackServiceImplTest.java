package com.cg.tms.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IFeedbackServiceImplTest {
	@Autowired
	private IFeedbackService fService;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void addFeedback() {
	Feedback feed = new Feedback("Nice Experience", 5, LocalDate.now());
	Feedback feedFound = fService.addFeedback(feed);
	Assertions.assertEquals(feedFound.getFeedback(), feed.getFeedback());
	}
	
	@Test
	public void findByFeedbackId() throws FeedbackNotFoundException {
	Feedback feed = new Feedback("Nice Experience",5,LocalDate.now());
	em.persist(feed);
	Feedback feedFound = fService.findByFeedbackId(feed.getFeedbackId());
	Assertions.assertEquals(feedFound.getFeedback(), feed.getFeedback());
	}
	
	@Test
	public void findByCustomerId() throws CustomerNotFoundException {
	Customer cust = new Customer("bina","bin123","delhi","9810859887","bina@gmail.com");
	em.persist(cust);
	Feedback feed = new Feedback("good",3,LocalDate.now());
	feed.setCustomer(cust);
	em.persist(feed);
	Feedback feedFound = fService.findByCustomerId(cust.getCustomerId());
	Assertions.assertEquals(feedFound.getFeedback(), feed.getFeedback());
	}
	
	@Test
	public void viewAllFeedbacks() {
	Feedback feed = new Feedback("good",3,LocalDate.now());
	em.persist(feed);
	List<Feedback> feedFound = fService.viewAllFeedbacks();
	Assertions.assertNotNull(feedFound);
	}

}
