package com.cg.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.tms.repository.ICustomerRepository;

@SpringBootApplication
public class TMSMain {

	public static void main(String[] args) {
		SpringApplication.run(TMSMain.class, args);
		System.out.println("_________Trip Management System Started Listening to port 8085_________");
		
		
	}

}
