package com.example.demoJPA.service;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.model.Order;
import com.example.demoJPA.repository.CustomerRepository;
import com.example.demoJPA.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Order> getAllOrdersByCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return ordersRepository.findAllByCustomer(customer.get());
    }

}
