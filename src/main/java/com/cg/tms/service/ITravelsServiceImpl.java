package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.ITravelsRespository;

@Service
@Transactional
public class ITravelsServiceImpl implements ITravelsService {

	@Autowired
	private ITravelsRespository tRep;
	
	@Override
	public Travels addTravels(Travels travels) {
		Travels trav = tRep.save(travels);
		return trav;
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		boolean check = tRep.existsById(travels.getTravelsId());
		if(!check)
		{	
			throw new TravelsNotFoundException("Travels Not Found at Id:"+travels.getTravelsId());
		}
		Travels trav = tRep.save(travels);
		return trav;
	}

	@Override
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = tRep.findById(travelsId);
        if (!opt.isPresent()) {
        	throw new TravelsNotFoundException("Travels Not Found at Id:"+ travelsId);
        }
        Travels trav = opt.get();
        tRep.delete(trav);
		return trav;
	}

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = tRep.findById(travelsId);
        if (!opt.isPresent()) {
        	throw new TravelsNotFoundException("Travels Not Found at Id:"+travelsId);	
        }
        Travels trav = opt.get();
        return trav;
	}

	@Override
	public List<Travels> viewTravels() {
		List<Travels> viewAll=tRep.findAll();
		return viewAll;
	}

}
