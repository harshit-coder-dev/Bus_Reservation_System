package com.masai.respository;

import com.masai.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {

//    @Query("from Route where routeFrom=?1 and routeTo=?2")
    public Route findByRouteFromAndRouteTo(String routeFrom,String routeTo);
    
}
