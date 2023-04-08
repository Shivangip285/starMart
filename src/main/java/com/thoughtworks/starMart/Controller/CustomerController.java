package com.thoughtworks.starMart.Controller;

import com.thoughtworks.starMart.Model.Customer;
import com.thoughtworks.starMart.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomerDetails());
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.addCustomerDetails(customer));
    }

    @PatchMapping("/updateCustomer/")
    public ResponseEntity<Customer> updateCustomer(@RequestParam int id, @RequestBody Map<Object,Object> customer){
       return ResponseEntity.ok().body(customerService.updateCustomerDetails(id,customer));
    }

    @DeleteMapping("/removeCustomer")
    public ResponseEntity<Customer> removeCustomer(@RequestParam int id){
        return ResponseEntity.ok().body(customerService.removeCustomerDetails(id));
    }
}
