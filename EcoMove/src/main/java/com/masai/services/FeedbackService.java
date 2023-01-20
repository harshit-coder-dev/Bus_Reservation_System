package com.masai.services;

import java.util.List;

import com.masai.entities.Feedback;
import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.UserException;

public interface FeedbackService {
public Feedback addFeedback(Feedback feedback, Integer busId,String key)throws BusException, UserException;
	
	public Feedback updateFeedback(Feedback feedback, String Key)throws FeedbackException, UserException;
	
	public Feedback viewFeedback(Integer feedBackId)throws FeedbackException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;
}
