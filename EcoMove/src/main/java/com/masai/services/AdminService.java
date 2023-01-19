package com.masai.services;

import com.masai.entities.Admin;
import com.masai.exceptions.AdminException;

public interface AdminService {


    public Admin createAdmin(Admin admin)throws AdminException;

    public Admin updateAdmin(Admin admin,String key)throws AdminException;
}
