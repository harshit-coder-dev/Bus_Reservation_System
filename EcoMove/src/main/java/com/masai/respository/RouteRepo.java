package com.masai.respository;

import com.masai.entities.Route;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {
	@Query("select * from route where routefrom =:source AND routeTo = :destination")
	Route findByrouteFromAndrouteTo(@NotNull(message = "Start point cannot be null!")@Param("source") String source,
			@NotNull(message = "Destination point cannot be null!") @Param("destination")String destination);

	
//    public Route findByRouteFromSourceToDestination(String source,String destination);
    
}
