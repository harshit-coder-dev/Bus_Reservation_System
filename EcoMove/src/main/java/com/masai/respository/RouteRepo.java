package com.masai.respository;

import com.masai.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {

<<<<<<< HEAD
//    @Query("select r from Route r where r.routeFrom=?1 and r.routeTo=?2")
    public Route findByRouteFromSourceToDestination(String source,String destination);
=======
//    @Query("from Route where routeFrom=?1 and routeTo=?2")
    public Route findByRouteFromAndRouteTo(String routeFrom,String routeTo);
>>>>>>> 74326845daffdbe1b0aa002e76e020309b4f4c28
    
}
