package com.masai.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotNull(message = "userName cannot be null!")
	@Size(min = 5, max = 15, message = "UserName should not be less than size 5 and more than 15.")
	private String userName;
	
	@NotNull(message = "Name cannot be null!")
	@Size(min = 2, max = 15, message = "FirstName should not be less than size 2 and more than 15.")
	private String firstName;


	private String lastName;

	@NotNull(message = "Password cannot be null!")
	@NotBlank(message = "Password cannot be blank!")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
	private String password;

	@NotNull(message = "Mobile number cannot be null!")
//	@NotBlank(message = "Mobile number cannot be blank!")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
//	@Size(min = 10, max = 10)
	private String contact;

	@NotNull(message = "Email cannot be null!")
	@Email(message = "Invalid Email address.")
	private String email;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Reservation> reservations = new ArrayList<>();
}
