package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
