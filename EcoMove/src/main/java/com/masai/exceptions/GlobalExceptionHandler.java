package com.masai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException adminException, WebRequest req) {

        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setMessage(adminException.getMessage());
        errorDetails.setErrorDetails(req.getDescription(false));


        return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException loginException, WebRequest req) {


        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setMessage(loginException.getMessage());
        errorDetails.setErrorDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException userException, WebRequest req) {

        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setMessage(userException.getMessage());
        errorDetails.setErrorDetails(req.getDescription(false));


        return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(BusException.class)
    public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException busException, WebRequest req) {


        MyErrorDetails errorDetails = new MyErrorDetails();
        errorDetails.setTimeStamp(LocalDateTime.now());
        errorDetails.setMessage(busException.getMessage());
        errorDetails.setErrorDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }
}
