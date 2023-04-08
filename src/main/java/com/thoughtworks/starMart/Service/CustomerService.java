package com.thoughtworks.starMart.Service;

import com.thoughtworks.starMart.Model.Customer;
import com.thoughtworks.starMart.Repository.CustomerRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomerDetails(){
        return customerRepo.findAll();
    }
    public Customer addCustomerDetails(Customer customer){
        return customerRepo.save(customer);
    }
    public Customer updateCustomerDetails(int id, Map<Object, Object> customer){
        Customer customerById = customerRepo.findById(id);
        if(!customer.isEmpty()) {
            if(!(customer.get("surname") ==null))
                customerById.setSurname((String) customer.get("surname"));
            if(!(customer.get("emailId") ==null))
                customerById.setEmailId((String) customer.get("emailId"));
            if(!(customer.get("mobileNumber") ==null))
                customerById.setMobileNumber((Long) customer.get("mobileNumber"));
            return customerById;
        }
        Customer customer1 = customerRepo.save(customerById);
        return customer1;
    }

    public Customer removeCustomerDetails(int id){
        Customer customerById = customerRepo.findById(id);
        customerRepo.deleteById(id);
        return customerById;
    }
}
