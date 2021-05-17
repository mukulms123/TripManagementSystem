package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;
import com.cg.tms.repository.IReportRepository;

@Service
@Transactional
public class IReportServiceImpl implements IReportService {

	// For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private IReportRepository rRep;

	// Used to add Report
	@Override
	public Report addReport(Report report) {
		Report rept = rRep.save(report);
		logger.info("********Adding Report by Id: " + rept.getReportId() + "********");
		return rept;
	}

	// Used to delete Report
	@Override
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		Report report = viewReport(reportId);
		rRep.delete(report);
		logger.info("********Deleting Report by Id: " + reportId + "********");
		return report;
	}

	// Used to view Report using Report ID
	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		Optional<Report> optional = rRep.findById(reportId);
		if (!optional.isPresent()) {
			throw new ReportNotFoundException("Report Not Found at Id:" + reportId);
		}
		Report report = optional.get();
		logger.info("********Viewing Report by Id: " + report.getReportId() + "********");
		return report;
	}

	// Used for viewing all Reports
	@Override
	public List<Report> viewAllReports() {
		List<Report> reports = rRep.findAll();
		logger.info("********Viewing all Reports: " + reports + "********");
		return reports;
	}

}
