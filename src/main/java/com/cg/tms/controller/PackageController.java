package com.cg.tms.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.PackageDetails;
import com.cg.tms.dto.PackageRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.ICustomerService;
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

	@Autowired
	private ICustomerService cService;

	// Used for Testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from Package!!";
	}

	// Used for adding package
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public PackageDetails addPackage(@RequestBody @Valid PackageRequest requestData) throws CustomerNotFoundException {
		Package1 pack = new Package1(requestData.getPackageName(), requestData.getPackageDescription(),
				requestData.getPackageType(), requestData.getPackageCost());
		Booking book = requestData.getBooking();
		if (book != null) {
			Customer cust = cService.viewCustomer(book.getUserId());
			if (cust != null) {
				pack.addBooking(book);
			}
		}
		Hotel hotel = requestData.getHotel();
		if (hotel != null) {
			pack.addHotel(hotel);
		}
		Package1 finPack = pService.addPackage(pack);
		PackageDetails packageDetails = packageUtil.toDetailsPackage(finPack);
		return packageDetails;
	}

	// Used for deleting Package
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public PackageDetails deletePackage(@PathVariable("id") @Min(1) int packageId) throws PackageNotFoundException {
		Package1 pack = pService.deletePackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailsPackage(pack);
		return packageDetails;
	}

	// Used for viewing Package using Package ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public PackageDetails viewPackage(@PathVariable("id") @Min(1) int packageId) throws PackageNotFoundException {
		Package1 pack = pService.searchPackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailsPackage(pack);
		return packageDetails;
	}

	// Used for Viewing all Packages
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<PackageDetails> viewAllPackage() throws PackageNotFoundException {
		List<Package1> packs = pService.viewAllPackages();
		List<PackageDetails> packageDetails = packageUtil.toDetailsPackages(packs);
		return packageDetails;
	}

}
