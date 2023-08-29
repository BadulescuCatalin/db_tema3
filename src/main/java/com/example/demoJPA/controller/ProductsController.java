package com.example.demoJPA.controller;

import com.example.demoJPA.model.Product;
import com.example.demoJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/insertProduct")
    public void insertProduct() {
        Product p = new Product();
        p.setName("Coca-Cola");
        p.setStock(100);
        p.setDescription("Un suc foarte foarte bun!");
        p.setPrice(7.99);
        productService.insertProduct(p);
    }

}
