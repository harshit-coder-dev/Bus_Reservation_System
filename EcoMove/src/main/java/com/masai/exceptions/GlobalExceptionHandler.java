package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //User-defined exception handlers:

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails> adminExceptionHan(AdminException bnf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BusException.class)
    public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(FeedbackException.class)
    public ResponseEntity<MyErrorDetails> feedbackExceptionHandler(FeedbackException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<MyErrorDetails> reservationExceptionHandler(ReservationException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RouteException.class)
    public ResponseEntity<MyErrorDetails> routeExceptionHandler(RouteException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException isf, WebRequest req) {

        MyErrorDetails customizeErr = new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
    }


    //possible exception handlers:

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<MyErrorDetails> noSuchMethodExceptionHandler(NoSuchMethodException nsme, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(nsme.getMessage());
        err.setErrorDetails(req.getDescription(false));


        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noHandlerFoundExpHandler(NoHandlerFoundException nhfe, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nhfe.getMessage(), req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage("Validation Error!");
        err.setErrorDetails(manve.getBindingResult().getFieldError().getDefaultMessage());


        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    //Generic exception handler:

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e, WebRequest req) {

        MyErrorDetails error = new MyErrorDetails();
        error.setTimeStamp(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setErrorDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
    }

}
