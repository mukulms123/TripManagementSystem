package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

}
