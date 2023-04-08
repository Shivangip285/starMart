package com.thoughtworks.starMart.Repository;

import com.thoughtworks.starMart.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    public Customer findById(int id);
    public Customer findCustomerByEmailId(String email);
}
