package com.zensar.products.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.products.bean.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
