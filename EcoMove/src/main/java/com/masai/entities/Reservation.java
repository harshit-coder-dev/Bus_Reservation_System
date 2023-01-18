package com.masai.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;
	
	private String reservationStatus;

	private String reservationType;
	
	private LocalDate reservationDate;
	
	private LocalTime reservationTime;
	
	private String source;
	
	private String destination;
	
	private LocalDate journeyDate; // self added field
	
	private Integer noOfSeatsBooked; // self added field
	
	private Integer fare; // self added field

	@ManyToOne
	private Bus bus;

	@ManyToOne
	private User user;
}
