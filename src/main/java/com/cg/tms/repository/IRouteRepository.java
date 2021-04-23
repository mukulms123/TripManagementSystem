package com.cg.tms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer>{
	
	
//	public  Route  addRoute(Route route);
//	public  Route  updateRoute(Route route) throws RouteNotFoundException;
//	public  Route   removeRoute(int routeId) throws RouteNotFoundException;
//	public  Route    searchRoute(int routeId) throws RouteNotFoundException;
//	public  List<Route> viewRouteList();
	
	
	
	

}
