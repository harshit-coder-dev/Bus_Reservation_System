package com.masai.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Bus;
import com.masai.entities.CurrentUserSession;
import com.masai.entities.Reservation;
import com.masai.entities.ReservationDTO;
import com.masai.entities.User;
import com.masai.exceptions.ReservationException;
import com.masai.respository.ReservationDao;
import com.masai.respository.UserRepository;
import com.masai.respository.BusDao;
import com.masai.respository.BusRepo;
@Service
public class ReservationServiceImplementation implements ReservationService{
	
	@Autowired
	private ReservationDao reservationdao;
	
	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private BusRepo busdao;

	@Override
	public Reservation addReservation(ReservationDTO reservation) throws ReservationException{
		Reservation new_reservation = new Reservation();
		//add the reservation to list of reservations in user
		User currentCustomer = userdao.findById(reservation.getUserId()).orElseThrow(()->new ReservationException("Invalid user"));
		//check if the bus is valid
		Bus bookedBus = busdao.findById(reservation.getBusId()).orElseThrow(()->new ReservationException("Invalid bus"));
		//does it have available seats
		if(bookedBus.getAvailableSeats()>reservation.getNumber_of_seats()) {
			//updating seat count
			bookedBus.setAvailableSeats(bookedBus.getAvailableSeats()+reservation.getNumber_of_seats());
			//making a reservation
			new_reservation.setBus(bookedBus);
			new_reservation.setDestination(bookedBus.getDestination());
			new_reservation.setFare(bookedBus.getFarePerSeat()*reservation.getNumber_of_seats());
			new_reservation.setJourneyDate(reservation.getReservation_date());
			new_reservation.setNoOfSeatsBooked(reservation.getNumber_of_seats());
			new_reservation.setReservationDate(LocalDate.now());
			new_reservation.setReservationStatus("Succesful");
			new_reservation.setReservationTime(LocalTime.now());
			new_reservation.setReservationType("online");
			new_reservation.setSource(bookedBus.getSource());
			new_reservation.setUser(currentCustomer);
			return new_reservation;
		}else {
			new ReservationException("seats are not available");
		}
		return new_reservation;
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		
		return null;
	}

	@Override
	public Reservation deleteReservation(int reservationId) throws ReservationException{
		Reservation reservation = reservationdao.findById(reservationId).orElseThrow(()->new ReservationException("No Resrvation found with this reservation Id"));
		Bus bookedBus = (reservation.getBus());
		bookedBus.setAvailableSeats(bookedBus.getAvailableSeats()-reservation.getNoOfSeatsBooked());
		reservation.setReservationStatus("cancelled");
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
