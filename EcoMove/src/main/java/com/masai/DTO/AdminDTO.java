package com.masai.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    @NotNull(message = "Mobile number should not be null")
    @NotBlank(message = "Mobile Number should not be blank...!")
    private String mobileNumber;

    @NotNull(message="password should not be null")
    @NotBlank(message = "Password should not be blank...!")
    private String adminPassword;
}