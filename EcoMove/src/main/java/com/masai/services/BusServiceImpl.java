package com.masai.services;

import com.masai.entities.Bus;
import com.masai.entities.CurrentAdminSession;
import com.masai.entities.Route;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.respository.BusRepo;
import com.masai.respository.CurrentAdminRepo;
import com.masai.respository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private CurrentAdminRepo currentAdminRepo;


    @Override
    public Bus addBus(Bus bus, String key) throws BusException, AdminException {
        CurrentAdminSession loggedInAdmin = currentAdminRepo.findByAdminUid(key);

        if (loggedInAdmin == null) {
            throw new AdminException("Please provide Registered Admin to add bus!");
        }
        Route route = routeRepo.findByRouteFromSourceToDestination(bus.getSource(), bus.getDestination());
        System.out.println(route);
        if (route != null) {
            route.getBusList().add(bus);
            bus.setRoute(route);
            return busRepo.save(bus);
        } else
            throw new BusException("Bus detail is not correct");
    }

    @Override
    public Bus updateBus(Bus bus, String key) throws BusException, AdminException, RouteException {
        CurrentAdminSession loggedInAdmin = currentAdminRepo.findByAdminUid(key);

        if (loggedInAdmin == null) {
            throw new AdminException("Admin is not Logged in or Incorrect Details");
        } else {
            Optional<Bus> opt = busRepo.findById(bus.getBusId());
            if (opt.isPresent()) {
                Bus existingBus = opt.get();

                Route route = routeRepo.findByRouteFromSourceToDestination(bus.getSource(), bus.getDestination());
                if (route != null) {
                    List<Bus> list = route.getBusList();
                    list.add(bus);
                    bus.setRoute(route);
                } else {
                    throw new RouteException("No such route found");
                }

                busRepo.save(bus);
                return existingBus;
            } else {
                throw new BusException("No Bus found with given details");
            }
        }
    }

    @Override
    public Bus deleteBus(int busId, String key) throws BusException, AdminException, RouteException {
        CurrentAdminSession loggedInAdmin = currentAdminRepo.findByAdminUid(key);
        if (loggedInAdmin == null) {
            throw new AdminException("Admin is not Logged in or Incorrect Details");
        } else {
            Optional<Bus> opt = busRepo.findById(busId);
            if (opt.isPresent()) {
                Bus b = opt.get();
                b.setRoute(null);
                busRepo.delete(b);
                return b;
            } else {
                throw new BusException("No Bus present with given id : " + busId);
            }
        }
    }

    @Override
    public Bus viewBus(int busId) throws BusException {
        Optional<Bus> opt = busRepo.findById(busId);
        if (opt.isPresent()) {
            Bus bus = opt.get();
            return bus;
        } else {
            throw new BusException("No Bus present with given id : " + busId);
        }
    }

    @Override
    public List<Bus> viewBusByType(String busType) throws BusException {
        List<Bus> busList = busRepo.findByBusType(busType);
        if (busList.size() > 0) {
            return busList;
        } else {
            throw new BusException("No Bus present with given id : " + busType);
        }
    }

    @Override
    public List<Bus> viewAllBus() throws BusException {
        List<Bus> busList = busRepo.findAll();
        if (busList.size() > 0) {
            return busList;
        } else {
            throw new BusException("No Bus present ");
        }
    }
}
