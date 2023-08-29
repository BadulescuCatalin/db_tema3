package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/allCustomers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer id) {
        Optional<Customer> optional = customerService.getCustomerById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }
        return ResponseEntity.badRequest().body(null);
    }


    @PutMapping(value = "/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomerInfo(@RequestBody Customer c,
                                                     @PathVariable(value = "id") Integer id) {
        Customer updatedCustomer = customerService.updateCustomer(c, id);
        if (updatedCustomer == null) {
            return ResponseEntity.badRequest().body("Invalid input");
        }
        return ResponseEntity.ok().body("Customer updated successfuly");
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Integer id) {
        String message = customerService.deleteCustomerById(id);
        return message.contains("successfuly") ? ResponseEntity.ok().body(message) : ResponseEntity.badRequest().body(message);
    }
}