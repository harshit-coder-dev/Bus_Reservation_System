package com.masai.controller;

import com.masai.DTO.AdminLoginDTO;
import com.masai.DTO.UserLoginDTO;
import com.masai.entities.CurrentAdminSession;
import com.masai.entities.CurrentUserSession;
import com.masai.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/portal")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //User login:


    @PostMapping("/login/user")
    public ResponseEntity<CurrentUserSession> logInUser(@Valid @RequestBody UserLoginDTO dto) {

        CurrentUserSession result = loginService.logIntoUserAccount(dto);

        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);

    }

    @PostMapping("/logout/user")
    public String logoutUser(@RequestParam(required = false) String key) {

        return loginService.logOutFromUserAccount(key);

    }


    // Admin Login


    @PostMapping("/login/admin")
    public ResponseEntity<CurrentAdminSession> logInAdmin(@Valid @RequestBody AdminLoginDTO dto) {

        CurrentAdminSession result = loginService.logIntoAdminAccount(dto);

        return new ResponseEntity<CurrentAdminSession>(result, HttpStatus.ACCEPTED);

    }

    @PostMapping("/logout/admin")
    public String logoutAdmin(@RequestParam(required = false) String key) {

        return loginService.logOutFromAdminAccount(key);

    }
}
