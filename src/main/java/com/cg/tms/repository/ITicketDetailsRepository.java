package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.TicketDetails;

@Repository
public interface ITicketDetailsRepository extends JpaRepository<TicketDetails, String> {

}
