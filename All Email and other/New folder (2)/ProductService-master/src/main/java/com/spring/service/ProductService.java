package com.spring.service;

import com.spring.entity.Product;
import com.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public Product getProduct(int pid){
        return repository.findById(pid).get();
    }
    public List<Product> getAllProduct(){
        return repository.findAll();
    }
    public Product updateProduct(Product product, int pid){
        return repository.findById(pid).map(p ->{
            p.setPname(product.getPname());
            p.setType(product.getType());
            p.setQty(product.getQty());
            p.setPrice(product.getPrice());
            return repository.save(p);
        }).orElseGet(()->{
            product.setPid(pid);
            return repository.save(product);
        });
    }
    public Map<String, Boolean> deleteProduct(int pid){
        repository.findById(pid).orElseThrow(()-> new RejectedExecutionException("Product not found to deletion"));
        repository.deleteById(pid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Product Deleted ", Boolean.TRUE);
        return response;
    }
}
