//package com.cust.service;
//
//import com.cust.classes.MyOrders;
//import com.cust.classes.Product;
//import com.cust.dto.Customer;
//import com.cust.repository.CustomeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CustomerService {
//
//    @Autowired
//    CustomeRepo repo;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//
//    public Customer saveCust(Customer c){
//        return repo.save(c);
//    }
//
//    public MyOrders getMyOrders(int custId){
//        Optional<Customer> cust = repo.findById(custId);
//        int pid = cust.get().getPid();
//
//        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/product"+pid, Product.class);
//        MyOrders myOrders = new MyOrders();
//        myOrders.setCutomer(cust.get());
//        myOrders.setProduct(product);
//        return myOrders;
//
//    }
//
//
//}
