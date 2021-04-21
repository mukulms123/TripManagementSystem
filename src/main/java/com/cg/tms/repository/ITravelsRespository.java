package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;

@Repository
public interface ITravelsRespository extends JpaRepository<Travels, Integer>{
	
		
//			public Travels  addTravels(Travels travels);
//			public Travels  updateTravels(Travels travels) throws TravelsNotFoundException;
//			public Travels  removeTravels(int travelsId) throws TravelsNotFoundException;
//			public Travels searchTravels(int travelsId) throws TravelsNotFoundException;
//			public  List<Travels>  viewTravels();
	
	

}
