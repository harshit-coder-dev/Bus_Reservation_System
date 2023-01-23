package com.masai.controller;

import com.masai.entities.Bus;
import com.masai.exceptions.BusException;
import com.masai.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/bus/admin")    // only route from and route to needed
    public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus, @RequestParam(required = false) String key) throws BusException {

        Bus newBus = busService.addBus(bus, key);

        return new ResponseEntity<>(newBus, HttpStatus.CREATED);
    }

    @PutMapping("/bus/admin")
    public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus, @RequestParam(required = false) String key) throws BusException {

        Bus newBus = busService.updateBus(bus, key);

        return new ResponseEntity<Bus>(newBus, HttpStatus.OK);
    }

    @DeleteMapping("/bus/admin/{busId}")
    public ResponseEntity<Bus> DeleteBus(@PathVariable("busId") Integer busId, @RequestParam(required = false) String key) throws BusException {

        Bus bus = busService.deleteBus(busId, key);

        return new ResponseEntity<Bus>(bus, HttpStatus.OK);
    }

    @GetMapping("/bus")
    public ResponseEntity<Bus> getBusesById(@RequestParam Integer busId) throws BusException {

        Bus bus = busService.viewBus(busId);

        return new ResponseEntity<Bus>(bus, HttpStatus.OK);
    }


    @GetMapping("/buses/{busType}")
    public ResponseEntity<List<Bus>> getBusesByType(@PathVariable("busType") String busType) throws BusException {

        List<Bus> listOfBuses = busService.viewBusByType(busType);

        return new ResponseEntity<List<Bus>>(listOfBuses, HttpStatus.OK);
    }

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getAllBuses() throws BusException {

        List<Bus> listOfBuses = busService.viewAllBus();

        return new ResponseEntity<List<Bus>>(listOfBuses, HttpStatus.OK);
    }
}
