package com.cg.tms.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.BookingRequest;
import com.cg.tms.dto.RouteDetails;
import com.cg.tms.dto.RouteRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Route;
import com.cg.tms.entities.TicketDetails;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.service.IRouteService;
import com.cg.tms.util.RouteUtil;

@RestController
@RequestMapping("/route")
@Validated
public class RouteController {
	
	@Autowired
	private IRouteService rService;
	
	@Autowired
	private RouteUtil routeUtil;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from feedback";		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public RouteDetails addRoute(@RequestBody @Valid RouteRequest requestData)
	{
		System.out.println("Adding Route ");
		System.out.println("req data: " + requestData);
		Route rout = new Route(requestData.getRouteFrom(),requestData.getRouteTo(),requestData.getDepartureTime(),requestData.getArrivalTime(),requestData.getDoj(),requestData.getPickupPoint(),requestData.getFare());
		Route route = rService.addRoute(rout);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public RouteDetails updateRoute(@RequestBody @Valid RouteRequest requestData,@PathVariable("id") @Min(1) Integer routeId)
	{
		System.out.println("Update Route ");
		System.out.println("req data: " + requestData);
		Route rout = new Route(requestData.getRouteFrom(),requestData.getRouteTo(),requestData.getDepartureTime(),requestData.getArrivalTime(),requestData.getDoj(),requestData.getPickupPoint(),requestData.getFare());
		rout.setRouteId(routeId);
		Route route = rService.addRoute(rout);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public RouteDetails deleteRoute(@PathVariable("id") @Min(1) Integer routeId) throws RouteNotFoundException
	{
		System.out.println("deleting Route");
		System.out.println("Route id: " + routeId);
		Route route = rService.removeRoute(routeId);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public RouteDetails searchRoute(@PathVariable("id") @Min(1) Integer routeId) throws RouteNotFoundException
	{
		System.out.println("View Route");
		System.out.println("Route id: " + routeId);
		Route route = rService.searchRoute(routeId);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<RouteDetails> viewRouteList() 
	{
		System.out.println("View All Routes");
		List<Route> routes = rService.viewRouteList();
		List<RouteDetails> routeDetails = routeUtil.toRouteDetail(routes);
		return routeDetails;
	}
	
	
}
