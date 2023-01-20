package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.CurrentUserSession;

@Repository
public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUserUID(String userUID);
}
