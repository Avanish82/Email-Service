package com.spring.controller;

import com.spring.entity.Product;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @GetMapping("/{pid}")
    public Product getProductDetails(@PathVariable int pid){
        return service.getProduct(pid);
    }
    @GetMapping("/")
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @PutMapping("/{pid}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int pid){
        return service.updateProduct(product, pid);
    }
    @DeleteMapping("/{pid}")
    public Map<String, Boolean> deleteProduct(@PathVariable int pid){
        return service.deleteProduct(pid);
    }
}
