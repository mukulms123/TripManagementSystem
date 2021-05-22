package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.TravelDetails;
import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Travels;

@Component
public class TravelUtil {

	public TravelDetails toTravelsDetail(Travels travel) {
		TravelDetails travelDetails = new TravelDetails(travel.getTravelsId(), travel.getTravelsName(),
				travel.getAgentName(), travel.getAddress(), travel.getContact());
		Bus bus = travel.getBus();
		travelDetails.setBus(bus);
		return travelDetails;
	}

	public List<TravelDetails> toTravelsDetail(Collection<Travels> travels) {
		List<TravelDetails> desired = new ArrayList<>();
		for (Travels travel : travels) {

			TravelDetails travelDetails = toTravelsDetail(travel);
			desired.add(travelDetails);
		}

		return desired;

	}

}
