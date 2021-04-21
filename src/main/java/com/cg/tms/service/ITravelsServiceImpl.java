package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.ITravelsRespository;


public class ITravelsServiceImpl implements ITravelsService {

	//create res object
	
	@Override
	public Travels addTravels(Travels travels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Travels> viewTravels() {
		// TODO Auto-generated method stub
		return null;
	}

}
