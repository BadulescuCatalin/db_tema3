package com.example.demoJPA.controller;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.model.Order;
import com.example.demoJPA.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/allOrders/customer/{id}")
    public List<Order> getAllOrdersForCustomer(@PathVariable Integer id) {
        return orderService.getAllOrdersByCustomer(id);
    }
}
