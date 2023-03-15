package com.cust.repository;

import com.cust.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomeRepo extends JpaRepository<Customer, Integer> {
}
