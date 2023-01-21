package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
