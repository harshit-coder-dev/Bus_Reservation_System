package com.masai.controller;

import com.masai.entities.Admin;
import com.masai.exceptions.AdminException;
import com.masai.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/portal")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //	http://localhost:8888/portal/admin
    @PostMapping("/admin")
    public ResponseEntity<Admin> registerAdminHandler(@Valid @RequestBody Admin admin) throws AdminException {

        Admin savedCustomer = adminService.createAdmin(admin);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }


    //	http://localhost:8888/portal/admin
    @PutMapping("/admin")
    public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin admin, @RequestParam(required = false) String key) throws AdminException {
        Admin updatedCustomer = adminService.updateAdmin(admin, key);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

    }
}
