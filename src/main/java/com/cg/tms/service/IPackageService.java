package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Package1;
import com.cg.tms.exceptions.PackageNotFoundException;

public interface IPackageService {
	
	
	public  Package1  addPackage(Package1 pack);
	public  Package1  deletePackage(int packageId) throws PackageNotFoundException;
	public  Package1  searchPackage(int packageId) throws PackageNotFoundException;
	public  List<Package1> viewAllPackages();
	
	

}
