package com.masai.services;

import java.util.List;

import com.masai.entities.Route;
import com.masai.exceptions.RouteException;

public interface RouteService {

	public Route AddRout(Route route) throws RouteException;
	
	
	public Route UpdateRoute(Route route) throws RouteException;
	
	
	public Route DeleteRoute(Integer RouteId) throws RouteException;
	
	
	public Route ViewRoute(Integer RouteId) throws RouteException;
	
	
	public List<Route> ViewAllRoute() throws RouteException;
}
