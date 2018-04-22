package com.example.demo.repo.db2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.db2.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {}
