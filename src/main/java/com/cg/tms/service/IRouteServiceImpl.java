package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.checkerframework.checker.nullness.Opt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;
import com.cg.tms.repository.IRouteRepository;

@Service
@Transactional
public class IRouteServiceImpl implements IRouteService {

	// For Logging
	private Logger logger = LoggerFactory.getLogger(IBookingServiceImpl.class);

	@Autowired
	private IRouteRepository rRep;

	@Override
	public Route addRoute(Route route) {
		Route rout = rRep.save(route);
		logger.info("********Adding Route by Id: " + route.getRouteId() + "********");
		return rout;
	}

	// Used for updating Route
	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		Optional<Route> optional = rRep.findById(route.getRouteId());
		if (!optional.isPresent()) {
			throw new RouteNotFoundException("Route Not Found at Id:" + route.getRouteId());
		}
		Route newRoute = rRep.save(route);
		logger.info("********Updating Route by Id: " + route.getRouteId() + "********");
		return newRoute;
	}

	// Used to remove Route
	@Override
	public Route removeRoute(int routeId) throws RouteNotFoundException {
		Route newRoute = searchRoute(routeId);
		if (newRoute == null) {
			throw new RouteNotFoundException("Route Not Found at Id: " + routeId);
		}
		rRep.delete(newRoute);
		logger.info("********Deleting Route by Id: " + routeId + "********");
		return newRoute;
	}

	// Used to search package
	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {
		Optional<Route> opt = rRep.findById(routeId);
		if (!opt.isPresent()) {
			throw new RouteNotFoundException("Route Not Found at Id:" + routeId);
		}
		Route newRoute = opt.get();
		logger.info("********Viewing Route by Id: " + routeId + "********");
		return newRoute;
	}

	// Used for viewing all Routes
	@Override
	public List<Route> viewRouteList() {
		List<Route> routeList = rRep.findAll();
		logger.info("********Viewing all Routes: " + routeList + "********");
		return routeList;
	}

}
