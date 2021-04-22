package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Package1;

@Repository
public interface IPackageRepository extends JpaRepository<Package1, Integer>{
	
	
//	public  Package  addPackage(Package pack);
//	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
//	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
//	public  List<Package> viewAllPackages();
	
	

}
