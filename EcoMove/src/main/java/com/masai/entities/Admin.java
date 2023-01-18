package com.masai.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;

	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	private String adminUsername;

	@NotNull(message = "Password cannot be null!")
	@NotBlank(message = "Password cannot be blank!")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}",
	message = "Password must be 8-15 characters in length and can include"
			+ " alphanumerics and special characters")
	private String adminPassword;

}
