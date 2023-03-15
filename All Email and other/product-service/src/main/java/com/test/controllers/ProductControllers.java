package com.test.controllers;

import com.test.dto.Product;
import com.test.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductControllers {

    @Autowired
    Productservice service;

    @GetMapping("/")
    public List<Product> getProducts(){
        return service.getAllProduct();
    }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product p){
        return service.saveProduct(p);
    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable("id") int pid){
        return service.getProductById(pid);
    }
}
