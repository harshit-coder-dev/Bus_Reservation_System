package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Route;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer>{

	public Route findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}
