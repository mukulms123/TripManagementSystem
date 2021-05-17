package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.ITravelsRespository;

@Service
@Transactional
public class ITravelsServiceImpl implements ITravelsService {

	// For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private ITravelsRespository tRep;

	// Used for adding Travels
	@Override
	public Travels addTravels(Travels travels) {
		Travels trav = tRep.save(travels);
		logger.info("********Adding Travel by Id: " + travels.getTravelsId() + "********");
		return trav;
	}

	// Used for Updating Travels
	@Override
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		boolean check = tRep.existsById(travels.getTravelsId());
		if (!check) {
			throw new TravelsNotFoundException("Travels Not Found at Id:" + travels.getTravelsId());
		}
		Travels trav = tRep.save(travels);
		logger.info("********Updating Travels by Id: " + travels.getTravelsId() + "********");
		return trav;
	}

	// Used for removing Travels using travel ID
	@Override
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = tRep.findById(travelsId);
		if (!opt.isPresent()) {
			throw new TravelsNotFoundException("Travels Not Found at Id:" + travelsId);
		}
		Travels trav = opt.get();
		logger.info("********Deleting Travels by Id: " + travelsId + "********");
		tRep.delete(trav);
		return trav;
	}

	// Used for searching Travels using Travels ID
	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = tRep.findById(travelsId);
		if (!opt.isPresent()) {
			throw new TravelsNotFoundException("Travels Not Found at Id:" + travelsId);
		}
		Travels trav = opt.get();
		logger.info("********Viewing Travels by Id: " + travelsId + "********");
		return trav;
	}

	// Used for viewing all Travels
	@Override
	public List<Travels> viewTravels() {
		List<Travels> travelsList = tRep.findAll();
		logger.info("********Viewing all Travels: " + travelsList + "********");
		return travelsList;
	}

}
