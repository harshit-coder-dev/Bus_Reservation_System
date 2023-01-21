package com.masai.respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entities.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer>{

	@Query("from Reservation where journeyDate=?1")
	List<Reservation> findbyjourneyDate(LocalDate date);

}
