package com.example.demoJPA.service;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Customer updateCustomer(Customer c, Integer id) {
        Optional<Customer> oldCustomer = customerRepository.findById(id);
        if(oldCustomer.isPresent()) {
            return customerRepository.save(c);
        }
        return null;
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public String deleteCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return "Customer deleted successfuly";
        }
        return "Invalid id";
    }

}
