package com.masai.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MyErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

}
