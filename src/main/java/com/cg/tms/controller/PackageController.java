package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.PackageDetails;
import com.cg.tms.dto.PackageRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.service.IPackageService;
import com.cg.tms.util.PackageUtil;

@RestController
@RequestMapping("/package")
@Validated
public class PackageController {

	@Autowired
	private IPackageService pService;
	
	@Autowired
	private PackageUtil packageUtil;
	
	@RequestMapping("/hello")
	public String feedbackGreet()
	{
		System.out.println("Greeting!!");
		return "Hello from Package!!";		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public PackageDetails addPackage(@RequestBody @Valid PackageRequest requestData)
	{
		System.out.println("Adding Package ");
		System.out.println("req data: " + requestData);
		Package1 pack = new Package1(requestData.getPackageName(),requestData.getPackageDescription(),requestData.getPackageType(),requestData.getPackageCost());
		Booking book = requestData.getBooking();
		if(book != null)
		{	
		pack.addBooking(book);
		}
		Hotel hotel = requestData.getHotel();
		if(hotel != null)
		{	
		pack.addHotel(hotel);
		}
		Package1 finPack = pService.addPackage(pack);	
		PackageDetails packageDetails = packageUtil.toDetailsPackage(finPack);
		return packageDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public PackageDetails addPackage(@PathVariable("id") @Min(1) int packageId) throws PackageNotFoundException
	{
		System.out.println("Deleting Package ");
		System.out.println("Package id: " + packageId);
		Package1 pack = pService.deletePackage(packageId);
		System.out.println(pack);
		PackageDetails packageDetails = packageUtil.toDetailsPackage(pack);
		return packageDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public PackageDetails viewPackage(@PathVariable("id") @Min(1) int packageId) throws PackageNotFoundException
	{
		System.out.println("View Package ");
		System.out.println("Package id: " + packageId);
		Package1 pack = pService.searchPackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailsPackage(pack);
		return packageDetails;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<PackageDetails> viewAllPackage() throws PackageNotFoundException
	{
		System.out.println("View All Packages ");
		List<Package1> packs = pService.viewAllPackages();
		System.out.println(packs);
		List<PackageDetails> packageDetails = packageUtil.toDetailsPackages(packs);
		return packageDetails;
	}
	
}
