package com.masai.services;

import com.masai.DTO.AdminLoginDTO;
import com.masai.DTO.UserLoginDTO;
import com.masai.entities.CurrentAdminSession;
import com.masai.entities.CurrentUserSession;
import com.masai.exceptions.LoginException;

public interface LoginService {


    public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto) throws LoginException;


    public String logOutFromAdminAccount(String key) throws LoginException;

    public CurrentUserSession logIntoUserAccount(UserLoginDTO dto) throws LoginException;

    public String logOutFromUserAccount(String key) throws LoginException;
}
