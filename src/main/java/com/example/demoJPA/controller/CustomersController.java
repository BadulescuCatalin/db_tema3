package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomersController {
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/insertCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer c) {
        Customer savedCustomer = customerService.addCustomer(c);
        if (savedCustomer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        return ResponseEntity.ok()
                .body("Customer added successfully!");
    }

    @GetMapping(value = "/allCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomerInfo(@RequestBody Customer c,
                                                     @PathVariable Integer id) {
        Customer updatedCustomer = customerService.updateCustomer(c);
        if (updatedCustomer == null) {
            return ResponseEntity.badRequest().body("Invalid input");
        }
        return ResponseEntity.ok().body("Customer updated successfuly");
    }
}
