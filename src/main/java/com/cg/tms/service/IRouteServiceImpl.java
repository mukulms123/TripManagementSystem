package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;
import com.cg.tms.repository.IRouteRepository;

@Service
@Transactional
public class IRouteServiceImpl implements IRouteService {

	@Autowired
	private IRouteRepository rRep;
	
	@Override
	public Route addRoute(Route route) {
		Route rout = rRep.save(route);
		return rout;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		Optional<Route> optional = rRep.findById(route.getRouteId());
		if (!optional.isPresent()) {
			throw new RouteNotFoundException();
		}
		Route newRoute = optional.get();
		newRoute.setRouteFrom(route.getRouteFrom());
		newRoute.setRouteTo(route.getRouteTo());
		newRoute = rRep.save(route);
		return newRoute;
	}

	@Override
	public Route removeRoute(String routeId) throws RouteNotFoundException {
		Route newRoute = searchRoute(routeId);
		rRep.delete(newRoute);
		return newRoute;
	}

	@Override
	public Route searchRoute(String routeId) throws RouteNotFoundException {
		Optional<Route> opt = rRep.findById(routeId);
		if (!opt.isPresent()) {
			throw new RouteNotFoundException();
		}
		Route newRoute = opt.get();
		return newRoute;
	}

	@Override
	public List<Route> viewRouteList() {
		List<Route> routeList = rRep.findAll();
		return routeList;
	}

}
