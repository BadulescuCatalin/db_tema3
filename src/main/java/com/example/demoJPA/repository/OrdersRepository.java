package com.example.demoJPA.repository;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomer(Customer customer);
}
