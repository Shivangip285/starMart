package com.thoughtworks.starMart.Service;

import com.thoughtworks.starMart.Model.Login;
import com.thoughtworks.starMart.Repository.AdminRepo;
import com.thoughtworks.starMart.Repository.CustomerRepo;
import com.thoughtworks.starMart.UserRole;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LoginLogoutService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public String login(Login loginUser){
        String loginObject = "";
        Object user = loginUser.getUserRole().equals(UserRole.Admin.toString()) ? adminRepo.findAdminByEmailId(loginUser.getEmailId()) : customerRepo.findCustomerByEmailId(loginUser.getEmailId());
        if(user!=null && user.toString().contains("password="+loginUser.getPassword())){
            loginObject=user.toString();
        }
        return loginObject;
    }

    public String logout(){
        return "Logout user";
    }

    public String changePassword(Login loginUser){
        String loginObject = "";
        Object user = loginUser.getUserRole().equals(UserRole.Admin.toString()) ? adminRepo.findAdminByEmailId(loginUser.getEmailId()) : customerRepo.findCustomerByEmailId(loginUser.getEmailId());
        if(user!=null && user.toString().contains("password="+loginUser.getPassword())){
            user.toString().replace("password="+loginUser.getPassword(),"password="+loginUser.getNewPassword());
            loginObject=user.toString();
        }
//        if(loginUser.getUserRole().equals(UserRole.Admin.toString())){
//            Admin adminByEmailId = adminRepo.findAdminByEmailId(loginUser.getEmailId());
//            if(adminByEmailId!=null && adminByEmailId.getPassword().equals(loginUser.getPassword())){
//                adminByEmailId.setPassword(loginUser.getNewPassword());
//                adminRepo.save(adminByEmailId);
//                System.out.println(adminByEmailId);
//                loginObject= String.valueOf(adminByEmailId);
//            }
//        }
//        else if(loginUser.getUserRole().equals(UserRole.Customer.toString())){
//            Customer customerByEmailId = customerRepo.findCustomerByEmailId(loginUser.getEmailId());
//            if (customerByEmailId != null && customerByEmailId.getPassword().equals(loginUser.getPassword())) {
//                loginObject= String.valueOf(customerByEmailId);
//            }
//        }
        return loginObject;
    }
}
