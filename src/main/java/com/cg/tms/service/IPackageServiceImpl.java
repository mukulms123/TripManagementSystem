package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IPackageRepository;

@Service
@Transactional
public class IPackageServiceImpl implements IPackageService {

	@Autowired
	private IPackageRepository pRes;
	
	@Override
	public Package addPackage(Package pack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package deletePackage(int packageId) throws PackageNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package searchPackage(int packageId) throws PackageNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Package> viewAllPackages() {
		// TODO Auto-generated method stub
		return null;
	}

}
