package com.test.service;

import com.test.dto.Product;
import com.test.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Productservice {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProduct(){
        return repo.findAll();
    }

    public Optional<Product> getProductById(int pid){
        return repo.findById(pid);
    }

    public Product saveProduct(Product productdto){
        return repo.save(productdto);
    }



}
