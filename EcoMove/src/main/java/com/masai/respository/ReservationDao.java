package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer>{

}
