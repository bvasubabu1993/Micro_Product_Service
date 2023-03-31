package com.app.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.main.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
