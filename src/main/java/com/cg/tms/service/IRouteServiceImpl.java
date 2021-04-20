package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;

@Service
@Transactional
public class IRouteServiceImpl implements IRouteService {

	@Autowired
	private IRouteRepository routeRes;
	@Override
	public Route addRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route removeRoute(int routeId) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route searchRoute(int routeId) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> viewRouteList() {
		// TODO Auto-generated method stub
		return null;
	}

}
