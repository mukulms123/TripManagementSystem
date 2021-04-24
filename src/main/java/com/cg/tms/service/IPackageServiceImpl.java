package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repository.IPackageRepository;

@Service
@Transactional
public class IPackageServiceImpl implements IPackageService {
	
	@Autowired
	private IPackageRepository pRep;
	
	@Override
	public Package1 addPackage(Package1 pack) {
		Package1 pack1 = pRep.save(pack);
		return pack1;
	}

	@Override
	public Package1 deletePackage(int packageId) throws PackageNotFoundException {
		Package1 pack = searchPackage(packageId);
        pRep.deleteById(packageId);
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
		return pack;
	}

	@Override
	public List<Package1> viewAllPackages() {
		List<Package1> packs = pRep.findAll();
		return packs;
	}

}
