package com.masai.services;

import com.masai.DTO.LoginDTO;
import com.masai.exceptions.LoginException;

public interface LoginService {

    public String logIntoUserAccount(LoginDTO dto)throws LoginException;

    public String logOutFromUserAccount(String key)throws LoginException;

    public String logIntoAdminAccount(LoginDTO dto)throws LoginException;

    public String logOutFromAdminAccount(String key)throws LoginException;

}
