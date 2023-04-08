package com.thoughtworks.starMart.Service;

import com.thoughtworks.starMart.Model.Admin;
import com.thoughtworks.starMart.Repository.AdminRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;


    public Admin addAdminDetails(Admin admin){
        return adminRepo.save(admin);
    }
    public Admin updateAdminDetails(int id, Map<Object, Object> admin){
        Admin adminById = adminRepo.findById(id);
        if(!admin.isEmpty()) {
            if(!(admin.get("surname") ==null))
                adminById.setSurname((String) admin.get("surname"));
            if(!(admin.get("emailId") ==null))
                adminById.setEmailId((String) admin.get("emailId"));
            return adminById;
        }
        Admin admin1 = adminRepo.save(adminById);
        return admin1;
    }

    public Admin removeAdminDetails(int id){
        Admin adminById = adminRepo.findById(id);
        adminRepo.deleteById(id);
        return adminById;
    }
}
