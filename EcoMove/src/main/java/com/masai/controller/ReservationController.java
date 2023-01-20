package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Reservation;
import com.masai.entities.ReservationDTO;
import com.masai.exceptions.ReservationException;
import com.masai.services.ReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationservice;
	
	
	@PostMapping("/newReservation")
	public ResponseEntity<Reservation>  addReservation(@Valid @RequestBody ReservationDTO reservation) throws ReservationException{
		return new ResponseEntity<Reservation>(reservationservice.addReservation(reservation),HttpStatus.OK);
	}
	
	@PutMapping("/updateReservation")
	public ResponseEntity<Reservation>  updateReservation(@Valid @RequestBody Reservation reservation) throws ReservationException{
		return new ResponseEntity<Reservation>(reservationservice.updateReservation(reservation),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMapping/{reservationId}")
	public ResponseEntity<Reservation>  deleteReservation(@Valid @RequestParam int reservationId) throws ReservationException{
		return new ResponseEntity<Reservation>(reservationservice.deleteReservation(reservationId),HttpStatus.OK);
	}
	
	@GetMapping("/viewreservation/{reservationId}")
	public ResponseEntity<Reservation>  viewReservation(@Valid @RequestParam int reservationId) throws ReservationException{
		return new ResponseEntity<Reservation>(reservationservice.viewReservation(reservationId),HttpStatus.OK);
	}
	
	@GetMapping("/viewallreservation")
	public ResponseEntity<List<Reservation>>  viewAllReservation() throws ReservationException{
		return new ResponseEntity<List<Reservation>>(reservationservice.viewAllReservation(),HttpStatus.OK);
	}
	
	@GetMapping("/getallreservation/{date}")
	public ResponseEntity<List<Reservation>>  getAllReservation(@Valid @RequestParam LocalDate date) throws ReservationException{
		return new ResponseEntity<List<Reservation>>(reservationservice.getAllReservation(date),HttpStatus.OK);
	}
}
