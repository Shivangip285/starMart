package com.thoughtworks.starMart.Repository;

import com.thoughtworks.starMart.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    public Admin findById(int id);
    public Admin findAdminByEmailId(String email);
}