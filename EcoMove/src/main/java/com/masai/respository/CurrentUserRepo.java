package com.masai.respository;

import com.masai.entities.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserRepo extends JpaRepository<CurrentUserSession,Integer> {

    public  CurrentUserSession  findByUseruid(String userUid);
}
