package com.cg.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.service.ICustomerService;

@SpringBootApplication
public class TMSMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TMSMain.class, args);
		System.out.println("_________Trip Management System Started Listening to port 8085_________");

	}

}
