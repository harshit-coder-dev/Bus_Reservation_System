package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Feedback;
import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.UserException;
import com.masai.services.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackservice;
	
	@PostMapping("/feedback/user/{busid}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback, @PathVariable("busid") Integer busId,
			@RequestParam(required = false) String key) throws UserException,BusException{
		
		Feedback givenFeedback = feedbackservice.addFeedback(feedback,busId,key);
		
		return new ResponseEntity<Feedback>(givenFeedback, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/feedback/user")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback feedback,@RequestParam(required = false) String key)
			throws FeedbackException, UserException {
		
		Feedback givenFeedback = feedbackservice.updateFeedback(feedback,key);
		
		return new ResponseEntity<Feedback>(givenFeedback, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws FeedbackException {
		
		Feedback givenFeedback = feedbackservice.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(givenFeedback, HttpStatus.OK);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws FeedbackException {
		
		List<Feedback> givenFeedback =  feedbackservice.viewAllFeedback();
		
		return new ResponseEntity<List<Feedback>>(givenFeedback, HttpStatus.ACCEPTED);
		
	}
}
