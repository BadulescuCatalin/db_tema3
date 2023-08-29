package com.example.demoJPA.service;

import com.example.demoJPA.model.Customer;
import com.example.demoJPA.model.Order;
import com.example.demoJPA.model.OrderDetail;
import com.example.demoJPA.model.Product;
import com.example.demoJPA.repository.CustomerRepository;
import com.example.demoJPA.repository.OrderDetailsRepository;
import com.example.demoJPA.repository.OrdersRepository;
import com.example.demoJPA.repository.ProductsRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public Product insertProduct(Product p) {
        return productsRepository.save(p);
    }

    public List<Product> getAllPorducts() {
        return productsRepository.findAll();
    }

    public void generate10Products() {
        for(int i=0; i<10; ++i) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setDescription("Description " + i);
            product.setPrice(i * 1.1);
            product.setStock(100);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPriceEach(product.getPrice());
            orderDetail.setQuantity(i);
            List<OrderDetail> orderDetailList = new ArrayList<>();
            orderDetailList.add(orderDetail);
            product.setOrderDetailList(orderDetailList);
            orderDetailsRepository.save(orderDetail);
            productsRepository.save(product);
        }
    }

    public void assignCustomer5Products() {
        Optional<Customer> optionalCustomer = customerRepository.findById(1);
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setShippedDate(new Date());
            order.setStatus("Pending");
            order.setCustomer(customer);
            List<OrderDetail> orderDetailList = orderDetailsRepository.findAll();
            List<OrderDetail> toAddList = new ArrayList<>();
            for(int i=0; i<5; ++i) {
                toAddList.add(orderDetailList.get(i));
            }
            order.setOrderDetailList(toAddList);
            ordersRepository.save(order);
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            customer.setOrders(orderList);
            customerRepository.save(customer);
        }
    }

}
