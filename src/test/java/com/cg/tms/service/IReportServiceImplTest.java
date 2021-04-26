package com.cg.tms.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;



@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IReportServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IReportServiceImplTest {
	
	@Autowired
	private IReportService rService;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void addReport() {
	Report report = new Report("report1","summary");
	Report reportFound = rService.addReport(report);
	Assertions.assertEquals(reportFound.getReportName(), report.getReportName());
	}
	
	@Test
	public void deleteReport() throws ReportNotFoundException {
	Report report = new Report("report1","summary");
	em.persist(report);
	Report reportFound = rService.deleteReport(report.getReportId());
	Assertions.assertEquals(reportFound.getReportName(), report.getReportName());
	}
	
	@Test
	public void viewReport() throws ReportNotFoundException {
	Report report = new Report("report1","summary");
	em.persist(report);
	Report reportFound = rService.viewReport(report.getReportId());
	Assertions.assertEquals(reportFound.getReportName(), report.getReportName());
	}
	
	@Test
	public void viewAllReports() {
	Report report = new Report("report1","summary");
	em.persist(report);
	List<Report> reportFound = rService.viewAllReports();
	Assertions.assertEquals(reportFound.get(0).getReportName(), report.getReportName());
	}
}
