package com.masai.controller;

import com.masai.DTO.LoginDTO;
import com.masai.exceptions.LoginException;
import com.masai.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //User login:


    @PostMapping("/user/login")
    public ResponseEntity<String> logInUserHandler(@RequestBody LoginDTO dto) throws LoginException {

        String result = loginService.logIntoUserAccount(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }


    @PostMapping("/user/logout")
    public String logoutUserHandler(@RequestParam(required = false) String key) throws LoginException {
        return loginService.logOutFromUserAccount(key);

    }


    // Admin Login


    @PostMapping("/admin/login")
    public ResponseEntity<String> logInAdminHandler(@RequestBody LoginDTO dto) throws LoginException {

        String result = loginService.logIntoAdminAccount(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }


    @PostMapping("/admin/logout")
    public String logoutAdminHandler(@RequestParam(required = false) String key) throws LoginException {
        return loginService.logOutFromAdminAccount(key);

    }
}
