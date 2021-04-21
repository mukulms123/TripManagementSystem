package com.cg.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IReportRepository;

@Service
@Transactional
public class IReportServiceImpl implements IReportService {

	@Autowired
	private IReportRepository rRes;
	
	@Override
	public Report addReport(Report report) {
		Report rept = rRes.save(report);
		return rept;		
	}

	@Override
	public Report deleteReport(int reportId) throws ReportNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report viewReport(int reportId) throws ReportNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report viewAllReports() {
		// TODO Auto-generated method stub
		return null;
	}

}
