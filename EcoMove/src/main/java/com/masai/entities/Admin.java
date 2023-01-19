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
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
    private String adminPassword;

    @NotNull(message = "Mobile number cannot be null!")
    @NotBlank(message = "Mobile number cannot be blank!")
    @Pattern(regexp = "[7986]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
    private String mobile;

}
