package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Package1;

@Repository
public interface IPackageRepository extends JpaRepository<Package1, Integer> {

}
