package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public User findByContact(String mobileNumber);
	
}
