package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Route;
import com.masai.exceptions.RouteException;
import com.masai.services.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	
	@PostMapping("/Route")
	public ResponseEntity<Route> AddNewRoute(@Valid @RequestBody  Route route) throws RouteException{
		
		Route thisRoute= routeService.AddRout(route);
		
		return new ResponseEntity<Route>(thisRoute, HttpStatus.CREATED);
	}


	
	@PutMapping("/Route")
	public ResponseEntity<Route> UpdateRoute(@Valid @RequestBody  Route route) throws RouteException{
		
		Route thisRoute= routeService.UpdateRoute(route);
		return new ResponseEntity<Route>(thisRoute, HttpStatus.CREATED);
	}

	
	

	@DeleteMapping("/ThisRoute/{id}")
	public ResponseEntity<Route> DeleteRoute(@PathVariable("id") Integer id) throws RouteException{
		
		Route thisRoute= routeService.DeleteRoute(id);
		return new ResponseEntity<Route>(thisRoute, HttpStatus.ACCEPTED);
	} 

	
	
	@GetMapping("/Route/{id}")
	public ResponseEntity<Route> ViewRouteById(@PathVariable("id") Integer id) throws RouteException{
		
		Route thisRoute= routeService.ViewRoute(id);
		return new ResponseEntity<Route>(thisRoute, HttpStatus.OK);
	}


	
	@GetMapping("/Route")
	public ResponseEntity<List<Route>> ViewRoute() throws RouteException{
		
		List<Route> thisRoute= routeService.ViewAllRoute();
		return new ResponseEntity<List<Route>>(thisRoute, HttpStatus.OK);
	}

}
