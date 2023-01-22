package com.masai.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masai.entities.Bus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    @NotNull(message = "Source of bus cannot be null... ")
    @NotBlank(message = "Source of bus cannot be blank... ")
    private String source;

    @NotNull(message = "Bus Destination cannot be null...")
    @NotBlank(message = "Bus Destination cannot be blank...")
    private String destination;

    @NotNull
    private Integer noOfSeatsToBook;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate journeyDate;

    private Bus busDTO;
}
