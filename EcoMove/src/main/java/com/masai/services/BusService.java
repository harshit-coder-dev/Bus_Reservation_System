package com.masai.services;

import com.masai.entities.Bus;
import com.masai.exceptions.BusException;

import java.util.List;

public interface BusService {

    Bus addBus(Bus bus) throws BusException;

    Bus updateBus(Bus bus) throws BusException;

    Bus deleteBusById(Integer id) throws BusException;

    Bus viewBus(Integer id) throws BusException;

    List<Bus> viewBusByType(String busType) throws BusException;

    List<Bus> viewAllBus() throws BusException;
}
