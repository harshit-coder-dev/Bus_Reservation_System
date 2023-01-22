package com.masai.services;

import com.masai.entities.Bus;
import com.masai.entities.CurrentAdminSession;
import com.masai.entities.Route;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.respository.AdminSessionDao;
import com.masai.respository.BusRepo;
import com.masai.respository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private AdminSessionDao adminSessionDao;


    @Override
    public Bus addBus(Bus bus, String key) throws BusException, AdminException {
        CurrentAdminSession loggedInAdmin = adminSessionDao.findByUuid(key);

        if (loggedInAdmin == null) {
            throw new AdminException("Please provide Registered Admin to add bus!");
        }
        Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
        System.out.println(route);
        if (route != null) {
            route.getBusList().add(bus);
            bus.setRoute(route);
            busRepo.save(bus);
            return  bus;
        } else
            throw new BusException("Bus detail is not correct");
    }

    @Override
    public Bus updateBus(Bus bus, String key) throws BusException, AdminException, RouteException {
        CurrentAdminSession loggedInAdmin = adminSessionDao.findByUuid(key);

        if (loggedInAdmin == null) {
            throw new AdminException("Admin is not Logged in or Incorrect Details");
        } else {
            Optional<Bus> opt = busRepo.findById(bus.getBusId());
            if (opt.isPresent()) {
                Bus existingBus = opt.get();
                Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());

                if (route == null) throw new BusException("Provided route in not valid...!");
                List<Bus> list = route.getBusList();
                list.add(bus);
                bus.setRoute(route);
                busRepo.save(bus);
                return existingBus;
            } else {
                throw new BusException("No Bus found with given details");
            }
        }
    }

    @Override
    public Bus deleteBus(Integer busId, String key) throws BusException, AdminException, RouteException {
        CurrentAdminSession loggedInAdmin = adminSessionDao.findByUuid(key);
        if (loggedInAdmin == null) {
            throw new AdminException("Admin is not Logged in or Incorrect Details");
        } else {
            Optional<Bus> opt = busRepo.findById(busId);
            if (opt.isPresent()) {
                Bus existingBus = opt.get();

                if (LocalDate.now().isBefore(existingBus.getBusJourneyDate()) && existingBus.getAvailableSeats() != existingBus.getSeats())
                    throw new BusException("Bus is having reservations, cannot be deleted...!");

                busRepo.delete(existingBus);

                return existingBus;
            } else {
                throw new BusException("No Bus present with given id : " + busId);
            }
        }
    }

    @Override
    public Bus viewBus(Integer busId) throws BusException {
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
