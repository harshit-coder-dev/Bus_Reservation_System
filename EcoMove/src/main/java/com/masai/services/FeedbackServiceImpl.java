package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.entities.Bus;
import com.masai.entities.CurrentUserSession;
import com.masai.entities.Feedback;
import com.masai.entities.User;
import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.UserException;
import com.masai.respository.BusRepo;
import com.masai.respository.CurrentUserRepo;
import com.masai.respository.FeedbackDao;
import com.masai.respository.UserRepository;

public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FeedbackDao fdao;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private CurrentUserRepo cuserRepo;
	
	@Override
	public Feedback addFeedback(Feedback feedback, Integer busId, String key) throws BusException, UserException {
		// TODO Auto-generated method stub
		CurrentUserSession logedinuser =cuserRepo.findByUseruid(key);
		if(logedinuser==null) throw new UserException("Authentication Failed!");
		Optional<User> opt=userRepo.findById(logedinuser.getUserId());
		if(opt.isEmpty()) throw new UserException("No user found!");
		User user=opt.get();
		Optional <Bus> busOpt = busRepo.findById(busId);
	    
	    if(busOpt.isEmpty()) {
	    	throw new BusException("Bus doesn't exist with Id "+ busId);
	    }
	    
	    feedback.setBus(busOpt.get());
	    feedback.setUser(user);
	    feedback.setFeedbackDate(LocalDateTime.now());
	    Feedback saved = fdao.save(feedback);
	    
	    return saved;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback, String Key) throws FeedbackException, UserException {
		// TODO Auto-generated method stub
		
		CurrentUserSession logedinuser =cuserRepo.findByUseruid(Key);
		if(logedinuser==null) throw new UserException("Authentication Failed!");
		Optional<User> opt=userRepo.findById(logedinuser.getUserId());
		if(opt.isEmpty()) throw new UserException("No user found!");
		User user=opt.get();
		Optional <Feedback> optional = fdao.findById(feedback.getFeedBackId());
		
		if(optional.isPresent()) {
            Feedback fb = optional.get();
			
			Optional<Bus> busOptional = busRepo.findById(fb.getBus().getBusId());
			
			if(!busOptional.isPresent()) throw new FeedbackException("Please enter valid bus details..!");
			
			feedback.setBus(busOptional.get());
			
			feedback.setUser(user);

			feedback.setFeedbackDate(LocalDateTime.now());

			return fdao.save(feedback);
		}
		throw new FeedbackException("Sorry..!No Feedback Found..!");
	}

	@Override
	public Feedback viewFeedback(Integer feedBackId) throws FeedbackException {
		// TODO Auto-generated method stub
		Optional<Feedback> feedback = fdao.findById(feedBackId);
		
		if (feedback.isPresent()) {

			return feedback.get();

		}
		throw new FeedbackException("Sorry..!No Feedback Found..!");
		
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		// TODO Auto-generated method stub
		List<Feedback> allfeedbacks=fdao.findAll();
		
		if (allfeedbacks.size()!=0){

			return allfeedbacks;

		}
		throw new FeedbackException("Sorry..!No Feedback Found..!");
	}

}
