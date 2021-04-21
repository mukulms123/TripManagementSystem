package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;

@Repository
public interface IReportRepository extends JpaRepository<Report, Integer>{
		
//		public Report  addReport(Report report);
//		public Report  deleteReport(int reportId) throws ReportNotFoundException;
//		public Report  viewReport(int reportId) throws ReportNotFoundException;
//		public Report  viewAllReports();
		
	
	
	

}
