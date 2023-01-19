package com.masai.controller;

import com.masai.entities.Bus;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
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

    @PostMapping("/buses")
    public ResponseEntity<Bus> createBus(@Valid @RequestBody Bus bus, @RequestParam(required = false) String key) throws BusException, RouteException, AdminException {
        return new ResponseEntity<Bus>(busService.addBus(bus, key), HttpStatus.CREATED);
    }

    @PutMapping("/buses")
    public ResponseEntity<Bus> updateBus(@RequestBody Bus bus, @RequestParam(required = false) String key) throws BusException, AdminException, RouteException {
        return new ResponseEntity<Bus>(busService.updateBus(bus, key), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/buses/{busId}")
    public ResponseEntity<Bus> deleteBus(@PathVariable("busId") Integer Id, @RequestParam(required = false) String key) throws BusException, AdminException, RouteException {
        return new ResponseEntity<Bus>(busService.deleteBus(Id, key), HttpStatus.OK);
    }

    @GetMapping("/buses/{busId}")
    public ResponseEntity<Bus> viewBusById(@PathVariable("busId") Integer Id) throws BusException {
        return new ResponseEntity<Bus>(busService.viewBus(Id), HttpStatus.ACCEPTED);

    }

    @GetMapping("/busByType/{busType}")
    public ResponseEntity<List<Bus>> viewBusByType(@PathVariable("busType") String type) throws BusException {
        return new ResponseEntity<List<Bus>>(busService.viewBusByType(type), HttpStatus.FOUND);

    }

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> viewAllBus() throws BusException {
        return new ResponseEntity<List<Bus>>(busService.viewAllBus(), HttpStatus.OK);

    }
}
