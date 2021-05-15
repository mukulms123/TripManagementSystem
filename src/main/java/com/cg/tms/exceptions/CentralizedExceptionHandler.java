package com.cg.tms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookingNotFoundException.class)
	public String handleBookingNotFound(BookingNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFound(CustomerNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeedbackNotFoundException.class)
	public String handleFeedbackNotFound(FeedbackNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(PackageNotFoundException.class)
	public String handlePackageException(PackageNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ReportNotFoundException.class)
	public String handleReportException(ReportNotFoundException e){
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RouteNotFoundException.class)
	public String handleRouteException(RouteNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(TravelsNotFoundException.class)
	public String handleTravelsException(TravelsNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserException(UserNotFoundException e) {
		return e.getMessage();
	}
}
