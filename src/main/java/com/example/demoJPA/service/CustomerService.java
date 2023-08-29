package com.example.demoJPA.service;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer c) {
        return customerRepository.save(c);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer c) {
        return customerRepository.save(c);
    }

}
