package com.masai.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;
	
	@NotNull(message = "Bus name cannot be null!")
	private String busName;
	
	@NotNull(message = "Bus driver name cannot be null!")
	private String driverName;
	
	@NotNull(message = "Bus Type cannot be null!")
	private String busType;
	
	@NotNull(message = "Start point cannot be null!")
	@NotBlank(message = "Start point cannot be blank!")
	private String routeFrom;
	
	@NotNull(message = "Destination point cannot be null!")
	@NotBlank(message = "Destination point cannot be blank!")
	private String routeTo;

	@NotNull(message = "Arrival time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime arrivalTime;

	@NotNull(message = "Departure time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime departureTime;

	@NotNull(message = "Total Seats cannot be null!")
	private Integer seats;

	@NotNull(message = "Available seats cannot be null!")
	private Integer availableSeats;

	@NotNull(message = "Fare cannot be null!")
	private Integer farePerSeat;  // self added field

	@ManyToOne
	private Route route;
	

}
