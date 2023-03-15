package com.cust.controller;

import com.cust.classes.MyOrders;
import com.cust.classes.Product;
import com.cust.dto.Customer;
import com.cust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCust(customer);
    }

    @GetMapping("/myorders/{cid}")
    public MyOrders myProductOrder(@PathVariable("cid")  int custId) {
        return customerService.getMyOrders(custId);
    }


}

