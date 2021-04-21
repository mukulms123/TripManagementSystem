package com.cg.tms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
	
	@Id
	@GeneratedValue
	private int reportId;
	private String reportName;
	private String reportType;
	
	//Adding Admin on my Own
//	@OneToOne
//	@JoinColumn(name = "admin_id")
//	private Admin admin;
	
	//Constructor without Admin
	public Report(int reportId, String reportName, String reportType) {
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
	}

	//Constructor without Admin and Id
	public Report(String reportName, String reportType) {
		this.reportName = reportName;
		this.reportType = reportType;
	}
	
	//toString without Admin
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType + "]";
	}

	//Default constructor
	public Report() {
	}

	//Getters and Setters
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

//	public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
}
