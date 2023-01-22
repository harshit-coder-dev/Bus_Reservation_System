package com.masai.respository;

import com.masai.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback,Integer> {
}
