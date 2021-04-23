package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.cg.tms.dto.ReportDetails;
import com.cg.tms.dto.TravelDetails;
import com.cg.tms.dto.TravelRequest;
import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Route;
import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.IBusRepository;
import com.cg.tms.service.ITravelsService;
import com.cg.tms.util.TravelUtil;

@RestController
@RequestMapping("/travel")
@Validated
public class TravelController {

	@Autowired
	private ITravelsService tService;
	
	@Autowired 
	private TravelUtil travelUtil;
	
	@Autowired
	private IBusRepository bRep;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Travel";		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public TravelDetails addTravels(@RequestBody @Valid TravelRequest requestData)
	{
		System.out.println("Creating Travels");
		System.out.println("req Data:"+requestData);
		Travels trav = new Travels(requestData.getTravelsName(),requestData.getAgentName(),requestData.getAddress(),requestData.getContact());
		Travels added = tService.addTravels(trav);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(added);
		return travelDetails;
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public TravelDetails updateTravels(@RequestBody @Valid TravelRequest requestData,@PathVariable @Min(1) int id) throws TravelsNotFoundException
	{
		System.out.println("Updating Travels");
		System.out.println("req Data:"+requestData);
		System.out.println("Id:"+id);
		Travels trav = new Travels(requestData.getTravelsName(),requestData.getAgentName(),requestData.getAddress(),requestData.getContact());
		trav.setTravelsId(id);
		Travels travel = tService.updateTravels(trav);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;
		
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public TravelDetails deleteTravels(@PathVariable("id") @Min(1) Integer travelId) throws TravelsNotFoundException 
	{
		System.out.println("deleting Route");
		System.out.println("Route id: " + travelId);
		Travels travel = tService.removeTravels(travelId);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public TravelDetails searchTravels(@PathVariable("id") @Min(1) Integer travelId) throws TravelsNotFoundException 
	{
		System.out.println("View Route");
		System.out.println("Route id: " + travelId);
		Travels travel = tService.searchTravels(travelId);	
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;
	
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<TravelDetails> viewTravels() 
	{
		System.out.println("View All Routes");
		List<Travels> travels = tService.viewTravels();
		List<TravelDetails> travelDetails = travelUtil.toTravelsDetail(travels);
		return travelDetails;		
	
	}
	
}
