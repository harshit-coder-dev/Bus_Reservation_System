package com.masai.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReservationDTO {
	
	private Integer busId;
	private Integer userId;
	private Integer number_of_seats;
	private LocalDate reservation_date;
	
	
	
}
