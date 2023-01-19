package com.masai.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Bus;
import com.masai.entities.CurrentUserSession;
import com.masai.entities.Reservation;
import com.masai.entities.ReservationDTO;
import com.masai.entities.User;
import com.masai.exceptions.ReservationException;
import com.masai.repository.BusDao;
import com.masai.respository.ReservationDao;
import com.masai.respository.UserRepository;
import com.masai.respository.BusDao;
@Service
public class ReservationServiceImplementation implements ReservationService{
	
	@Autowired
	private ReservationDao reservationdao;
	
	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private BusDao busdao;

	@Override
	public Reservation addReservation(ReservationDTO reservation) throws ReservationException{
		//add the reservation to list of reservations in user
		User currentCustomer = userdao.findById(reservation.getUserId()).orElseThrow(()->new ReservationException("Invalid user"));
		//check if the bus is valid
		Bus bookedBus = busdao.findById(reservation.getBusId()).orElseThrow(()->new ReservationException("Invalid bus"));
		//does it have available seats
		if(bookedBus.getAvailableSeats())
		//update the number of seats available in bus
		
		
		return null;
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		return null;
	}

	@Override
	public Reservation deleteReservation(int reservationId) throws ReservationException{
		Reservation reservation = reservationdao.findById(reservationId).orElseThrow(()->new ReservationException("No Resrvation found with this reservation Id"));
		reservationdao.delete(reservation);
		return reservation;
	}

	@Override
	public Reservation viewReservation(int reservationId) throws ReservationException{
		Reservation reservation = reservationdao.findById(reservationId).orElseThrow(()->new ReservationException("No Resrvation found with this reservation Id"));
		return reservation;
	}

	@Override
	public List<Reservation> viewAllReservation()  throws ReservationException{
		List<Reservation> reservations = reservationdao.findAll();
		return reservations;
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date)  throws ReservationException{
		List<Reservation> reservations = reservationdao.findbyjourneyDate(date);
		return reservations;
	}

}
