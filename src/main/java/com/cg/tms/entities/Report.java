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
	
	//constructor without admin
	public Report(int reportId, String reportName, String reportType) {
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
	}

	//Constructor without Admin and Id
	public Report(String reportName, String reportType) {
		super();
		this.reportName = reportName;
		this.reportType = reportType;
	}

	//Default Constructor
	public Report() {
	}

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

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType + "]\n";
	}
	
	//Generate Getters and Setters for admin
	
	
	
	
	

}
