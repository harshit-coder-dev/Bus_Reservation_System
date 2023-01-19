package com.masai.services;

import com.masai.entities.Bus;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;

import java.util.List;

public interface BusService {

    public Bus addBus(Bus bus, String key) throws BusException, AdminException;

    public Bus updateBus(Bus bus, String key) throws BusException, AdminException, RouteException;

    public Bus deleteBus(int busId, String key) throws BusException, AdminException, RouteException;

    public Bus viewBus(int busId) throws BusException;

    public List<Bus> viewBusByType(String busType) throws BusException;

    public List<Bus> viewAllBus() throws BusException;
}
