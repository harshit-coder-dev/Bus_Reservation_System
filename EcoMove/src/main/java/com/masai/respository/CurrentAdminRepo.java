package com.masai.respository;

import com.masai.entities.CurrentAdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAdminRepo extends JpaRepository<CurrentAdminSession,Integer> {

    public  CurrentAdminSession  findByAdminUid(String adminUid);
}
