package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.PaymentDetails;


@Repository
public interface IPaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer>{
	

}
