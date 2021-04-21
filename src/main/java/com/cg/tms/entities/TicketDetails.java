package com.cg.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_details")
public class TicketDetails {
	
	@Id
	@GeneratedValue
	private String ticketId;
	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;
	private String status;
	
	@OneToOne
	private Package pack;
	
	//constructor without id and route
	public TicketDetails(String status) {
		super();
		this.status = status;
	}

	//constructor without route
	public TicketDetails(String ticketId, String status) {
		super();
		this.ticketId = ticketId;
		this.status = status;
	}

	//Default Constructor
	public TicketDetails() {
	}

	//toString without route
	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", status=" + status +", Package=" + pack + "]";
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//Getter and Setter for Package
	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}
	
	//addPackage method
	public void addPackage(Package pack)
	{
		pack.setTicket(this);
		this.setPack(pack);
	}
	
}
