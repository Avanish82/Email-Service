package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFallbackController {

    @GetMapping("/cusService")
    public String customerService(){
        return "Customer Service is down ";
    }
    @GetMapping("/productService")
    public String productService(){
        return "Product Service is down";
    }
}
