package com.cg.tms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class Admin {
	
	
	private int  adminId;
	private String adminName;
	private  String password;
	private String email;
	private  String mobile;
	
}
