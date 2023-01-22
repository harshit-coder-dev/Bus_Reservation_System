package com.masai.respository;

import com.masai.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    public Admin findByMobileNumber(String mobileNumber);
}
