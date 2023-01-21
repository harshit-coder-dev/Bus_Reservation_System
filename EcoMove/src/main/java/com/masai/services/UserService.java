package com.masai.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.masai.entities.User;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;

@Configuration
public interface UserService {

	public User createUser(User user) throws UserException;

	public User updateUser(User user, String key) throws UserException;

	public User deleteUser(Integer userId, String key) throws UserException, AdminException;

	public User viewUserById(Integer userId, String key) throws UserException, AdminException;

	public List<User> viewUsers(String key) throws UserException, AdminException;

}
