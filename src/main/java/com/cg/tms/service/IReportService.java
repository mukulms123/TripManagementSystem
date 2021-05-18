package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.exceptions.UserNotFoundException;

public interface IReportService {
	
	
		public Report  addReport(Report report) throws UserNotFoundException;
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public List<Report>  viewAllReports();
		
	
	
	

}
