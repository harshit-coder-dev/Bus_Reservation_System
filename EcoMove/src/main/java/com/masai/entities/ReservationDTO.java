package com.masai.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReservationDTO {
	
	private Integer busId;
	private Integer userId;
	private Integer number_of_seats;
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(Integer number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
	
	
}
