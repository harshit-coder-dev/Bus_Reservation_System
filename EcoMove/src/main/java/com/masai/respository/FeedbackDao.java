package com.masai.respository;

import com.masai.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback,Integer> {
}
