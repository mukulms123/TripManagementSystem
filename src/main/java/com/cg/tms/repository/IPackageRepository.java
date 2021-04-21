package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.tms.entities.Package;

public interface IPackageRepository extends JpaRepository<Package, Integer>{
	
	
//	public  Package  addPackage(Package pack);
//	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
//	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
//	public  List<Package> viewAllPackages();
	
	

}
