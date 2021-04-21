package com.cg.tms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	
	//Adding Report on my Own 
//	@OneToOne//(mappedBy = "report", cascade = CascadeType.ALL)
//	private Report report;

	//Constructor without report and id
	public Admin(String adminName, String password, String email, String mobile) {
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;

	}
	
	//default constructor
	public Admin() {
	}

	//Getters and Setters
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

//	public Report getReport() {
//		return report;
//	}
//
//	public void setReport(Report report) {
//		this.report = report;
//	}
	
//	public void addReport(Report report) {
//		report.setAdmin(this);
//	}
}
