package com.example.demo.repo.db1;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.db1.Customer;
@Repository
  
public interface CustomerRepo extends JpaRepository<Customer, Integer> {}