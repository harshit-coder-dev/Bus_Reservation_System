package com.masai.services;

import com.masai.entities.Admin;
import com.masai.entities.CurrentAdminSession;
import com.masai.exceptions.AdminException;
import com.masai.respository.AdminRepo;
import com.masai.respository.CurrentAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private Admin admin;
    //private CurrentAdminRepo currentAdminRepo;

    @Override
    public Admin createAdmin(Admin admin) {
        Admin existingAdmin = adminRepo.findByMobile(admin.getMobile());
        if (existingAdmin != null) {
            throw new AdminException("Admin Already Registered with given Mobile number");
        }
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) {
//        CurrentAdminSession loggedInAdmin = currentAdminRepo.findByAdminUid(key);
//        if (loggedInAdmin == null) {
//            throw new AdminException("Please provide a registered admin");
//        }
//        if (loggedInAdmin.getAdminId() == admin.getAdminId()) {
//            return adminRepo.save(admin);
//        } else throw new AdminException("Invalid Admin Details, please login first");
    	return null;
    }
}
