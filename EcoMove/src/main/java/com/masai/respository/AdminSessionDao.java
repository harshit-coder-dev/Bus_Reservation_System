package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.CurrentAdminSession;

@Repository
public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {

    public CurrentAdminSession findByUuid(String uuid);

}
