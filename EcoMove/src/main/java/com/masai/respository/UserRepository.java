package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByMobileNumber(String mobileNumber);
}
