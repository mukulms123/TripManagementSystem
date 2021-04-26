package com.cg.tms.dto;

import javax.validation.constraints.NotNull;

public class ReportRequest {

	private int reportId;
	@NotNull
	private String reportName;
	@NotNull
	private String reportType;

	// Getters and Setters
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

}
