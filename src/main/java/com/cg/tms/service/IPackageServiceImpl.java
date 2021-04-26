package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IPackageRepository;

@Service
@Transactional
public class IPackageServiceImpl implements IPackageService {
	
	//For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);
	
	@Autowired
	private IPackageRepository pRep;
	
	@Override
	public Package1 addPackage(Package1 pack) {
		Package1 pack1 = pRep.save(pack);
		logger.info("********Adding Package by Id: "+pack1.getPackageId()+"********");
		return pack1;
	}

	@Override
	public Package1 deletePackage(int packageId) throws PackageNotFoundException {
		Package1 pack = searchPackage(packageId);
        pRep.deleteById(packageId);
        logger.info("********Deleting Package by Id: "+pack.getPackageId()+"********");
        return pack;
	}

	@Override
	public Package1 searchPackage(int packageId) throws PackageNotFoundException {
		Optional<Package1> opt = pRep.findById(packageId);
		if(!opt.isPresent())
		{
			throw new PackageNotFoundException("Package Not Found at Package Id:"+packageId);
		}
		Package1 pack = opt.get();
		logger.info("********Searching Package by Id: "+pack.getPackageId()+"********");
		return pack;
	}

	@Override
	public List<Package1> viewAllPackages() {
		List<Package1> packs = pRep.findAll();
		logger.info("********Viewing All Packages: "+packs+"********");
		return packs;
	}

}
