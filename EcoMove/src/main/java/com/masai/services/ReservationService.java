package com.masai.services;

import java.time.LocalDate;
import java.util.List;

import com.masai.entities.Reservation;
import com.masai.entities.ReservationDTO;
import com.masai.exceptions.ReservationException;

public interface ReservationService {
	public Reservation addReservation(ReservationDTO reservation) throws ReservationException;
	public Reservation updateReservation(Reservation reservation);
	public Reservation deleteReservation(int reservationId)throws ReservationException;
	public Reservation viewReservation(int reservationId) throws ReservationException;
	public List<Reservation> viewAllReservation()  throws ReservationException;
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException;
}
