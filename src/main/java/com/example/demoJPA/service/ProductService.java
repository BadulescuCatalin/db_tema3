package com.example.demoJPA.service;

import com.example.demoJPA.model.Product;
import com.example.demoJPA.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;

    public void insertProduct(Product p) {
        productsRepository.save(p);
    }
}
