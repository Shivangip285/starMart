package com.thoughtworks.starMart.Controller;


import com.thoughtworks.starMart.Model.Admin;
import com.thoughtworks.starMart.Service.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok().body(adminService.addAdminDetails(admin));
    }

    @PatchMapping("/updateAdmin/")
    public ResponseEntity<Admin> updateAdmin(@RequestParam int id, @RequestBody Map<Object,Object> admin){
        return ResponseEntity.ok().body(adminService.updateAdminDetails(id,admin));
    }

    @DeleteMapping("/removeAdmin")
    public ResponseEntity<Admin> removeAdmin(@RequestParam int id){
        return ResponseEntity.ok().body(adminService.removeAdminDetails(id));
    }

}
