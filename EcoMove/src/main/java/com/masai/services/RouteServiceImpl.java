package com.masai.services;

import java.util.List;
import java.util.Optional;

import com.masai.respository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Route;
import com.masai.exceptions.RouteException;

@Service
public class RouteServiceImpl implements RouteService{

	@Autowired
	private RouteRepo Routedao;

	@Override
	public Route AddRout(Route route) throws RouteException {
		
		Route routeFirst=Routedao.save(route);
		
		return routeFirst;
	}

	
	@Override
	public Route UpdateRoute(Route route) throws RouteException{
		
		Optional<Route> opt=Routedao.findById(route.getRouteId());
		
		if(opt.isPresent()) {
			
			Route r= Routedao.save(route);
			
			return r;
			
		}else {
			
			throw new RouteException("Sorry..!Route can't update..!");
		}
	}

	
	@Override
	public Route DeleteRoute(Integer RouteId) throws RouteException{
		
		Optional<Route> opt=Routedao.findById(RouteId);
		
		if(opt.isPresent()) {
			
			Routedao.deleteById(RouteId);
			
			return opt.get();
			
		}else {
			
			throw new RouteException("Sorry..!Route can't be deleted..!");
		}
		
	}

	
	@Override
	public Route ViewRoute(Integer RouteId) throws RouteException{
		
		Optional<Route> opt=Routedao.findById(RouteId);
		
		if(opt.isPresent()) {
			
			return opt.get();
			
		}else {
			
			throw new RouteException("Unable to view this route...!");
		}
		
	}

	
	@Override
	public List<Route> ViewAllRoute() throws RouteException{
		
		List<Route> routeList=Routedao.findAll();

		if(routeList.size()!=0) {
			
			return routeList;
			
		}else {
			
			throw new RouteException("Unable to view all routes at this time..!");
		}
	}
}
