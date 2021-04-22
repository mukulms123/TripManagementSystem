package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	@Autowired
	private IReportRepository rRep;
	
	@Override
	public Report addReport(Report report) {
		Report rept = rRep.save(report);
		return rept;
	}

	@Override
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		Report report = viewReport(reportId);
		rRep.delete(report);
		return report;
	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		Optional<Report> optional = rRep.findById(reportId);
		if (!optional.isPresent()) {
			throw new ReportNotFoundException();
		}
		Report report = optional.get();
		return report;
	}

	@Override
	public List<Report> viewAllReports() {
		List<Report> reports = rRep.findAll();
		return reports;
	}

}
