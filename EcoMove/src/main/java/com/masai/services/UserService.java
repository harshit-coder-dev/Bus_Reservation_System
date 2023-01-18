package com.masai.services;

import java.util.List;

import com.masai.entities.User;
import com.masai.exceptions.UserException;

public interface UserService {
	
    public User addUser(User user)throws UserException;
    public User updateUser(User user)throws UserException;
    public User deleteUser(Integer userId)throws UserException;
    public User viewUser(Integer userId)throws UserException;
    public List<User> viewAllUser()throws UserException;
    
}
