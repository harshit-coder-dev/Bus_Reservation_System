package com.masai.services;

import com.masai.DTO.LoginDTO;
import com.masai.entities.Admin;
import com.masai.entities.CurrentAdminSession;
import com.masai.entities.CurrentUserSession;
import com.masai.entities.User;
import com.masai.exceptions.LoginException;
import com.masai.respository.AdminRepo;
import com.masai.respository.CurrentAdminRepo;
import com.masai.respository.CurrentUserRepo;
import com.masai.respository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CurrentUserRepo currentUserRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CurrentAdminRepo currentAdminRepo;

    @Override
    public String logIntoUserAccount(LoginDTO dto) throws LoginException {
        User existingUser = userRepo.findByMobileNumber(dto.getMobileNo());
        if (existingUser == null) {
            throw new LoginException("Please Enter a valid mobile number");
        }
        Optional<CurrentUserSession> validUser = currentUserRepo.findById(existingUser.getUserId());

        if (validUser.isPresent()) {
            throw new LoginException("User already Logged In with this number");
        }
        if (existingUser.getPassword().equals(dto.getPassword())) {
            String key = RandomString.make(6);

            CurrentUserSession currentUserSession = new CurrentUserSession();
            currentUserSession.setUserUID(key);
            currentUserSession.setDateTime(LocalDateTime.now());
            currentUserRepo.save(currentUserSession);
            return currentUserRepo.toString();
        } else
            throw new LoginException("Please Enter a valid password");
    }

    @Override
    public String logOutFromUserAccount(String key) throws LoginException {
        CurrentUserSession currentUserSession = currentUserRepo.findByUseruid(key);
        if (currentUserSession != null) {
            currentUserRepo.delete(currentUserSession);
            return "Logged Out !, ThankYou for Service";
        } else throw new LoginException("User Not Logged In with this key");
    }

    @Override
    public String logIntoAdminAccount(LoginDTO dto) throws LoginException {
        Admin existingAdmin = adminRepo.findByMobile(dto.getMobileNo());
        if (existingAdmin == null) {
            throw new LoginException("Please Enter a valid mobile number");
        }
        Optional<CurrentAdminSession> validAdmin = currentAdminRepo.findById(existingAdmin.getAdminId());
        if (validAdmin.isPresent()) {
            throw new LoginException("Admin already Logged In with this number");
        }
        if (existingAdmin.getAdminPassword().equals(dto.getPassword())) {

            String key = RandomString.make(6);

            CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(), key, LocalDateTime.now());

            currentAdminRepo.save(currentAdminSession);

            return currentAdminSession.toString();
        } else
            throw new LoginException("Please Enter a valid password");
    }

    @Override
    public String logOutFromAdminAccount(String key) throws LoginException {
        CurrentAdminSession currentAdminSession = currentAdminRepo.findByAdminUid(key);
        if (currentAdminSession != null) {
            currentAdminRepo.delete(currentAdminSession);
            return "Logged Out !, ThankYou for Service";
        } else throw new LoginException("User Not Logged In with this key");
    }
}
