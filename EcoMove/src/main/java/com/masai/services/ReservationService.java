package com.masai.services;

import java.time.LocalDate;
import java.util.List;

import com.masai.DTO.ReservationDTO;
import com.masai.entities.Reservation;
import com.masai.exceptions.ReservationException;
import com.masai.exceptions.UserException;

public interface ReservationService {
    public Reservation addReservation(ReservationDTO reservation, String key) throws ReservationException, UserException;

    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, UserException;

    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException;

    public List<Reservation> viewAllReservation(String key) throws ReservationException;

    public List<Reservation> viewReservationByUser(String key) throws UserException;
}
