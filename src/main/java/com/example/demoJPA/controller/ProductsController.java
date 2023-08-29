package com.example.demoJPA.controller;

import com.example.demoJPA.model.Product;
import com.example.demoJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/initialize")
    public void initialize() {
        productService.generate10Products();
        productService.assignCustomer5Products();
    }


    @GetMapping(value = "/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllPorducts();
    }

    @PostMapping(value = "/insertProduct")
    public ResponseEntity<String> insertProduct(@RequestBody Product product) {
        Product p = productService.insertProduct(product);
        if (p != null) {
            return ResponseEntity.ok().body("Product added successfuly");
        }
        return ResponseEntity.badRequest().body("Invalid input");
    }

}
