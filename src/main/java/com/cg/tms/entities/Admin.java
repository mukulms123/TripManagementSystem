package com.cg.tms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue
	private int  adminId;
	private String adminName;
	private  String password;
	private String email;
	private  String mobile;
	
	//
	
	
	
	

}
