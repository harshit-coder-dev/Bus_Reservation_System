package com.masai.respository;

import com.masai.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusDao extends JpaRepository<Bus,Integer> {

}
