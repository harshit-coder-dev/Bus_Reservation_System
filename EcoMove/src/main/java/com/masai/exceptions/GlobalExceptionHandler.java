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

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> adminExceptionHan(AdminException bnf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetails> feedbackExceptionHandler(FeedbackException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<MyErrorDetails> reservationExceptionHandler(ReservationException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> routeExceptionHandler(RouteException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException isf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> notFoundUri(NoHandlerFoundException nhf, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> anyGenericException(Exception e, WebRequest req){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationErr(MethodArgumentNotValidException me){
		
		MyErrorDetails customizeErr= new MyErrorDetails(LocalDateTime.now(), "Validation Error", me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(customizeErr, HttpStatus.BAD_REQUEST);

	}
}
