package com.masai.services;

import com.masai.entities.Admin;
import com.masai.entities.CurrentAdminSession;
import com.masai.exceptions.AdminException;
import com.masai.respository.AdminRepo;
import com.masai.respository.AdminSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private AdminSessionDao adminSessionDao;

    @Override
    public Admin createAdmin(Admin admin) {
        Admin existingAdmin = adminRepo.findByMobileNumber(admin.getMobileNumber());
        if (existingAdmin != null) {
            throw new AdminException("Mobile number is already existed, admin cannot be created...!");
        }
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) {
        CurrentAdminSession loggedInAdmin = adminSessionDao.findByUuid(key);

        if (loggedInAdmin == null) {
            throw new AdminException("Please enter valid key for updating Admin Details...!");
        }

        if (admin.getAdminId() == loggedInAdmin.getAdminId()) {

            return adminRepo.save(admin);
        } else
            throw new AdminException("Invalid Admin Details, please login first...!");
    }
}
