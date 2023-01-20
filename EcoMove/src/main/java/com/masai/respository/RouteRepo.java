package com.masai.respository;

import com.masai.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route,Integer> {

    public Route findByRouteFromSourceToDestination(String source,String destination);
    
}
