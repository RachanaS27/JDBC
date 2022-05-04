package com.zensar.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.products.bean.Product;
import com.zensar.products.db.ProductDAO;


@Service
public class ProductService {

	@Autowired
	ProductDAO dao;
	
	public Product addProduct(Product product) {
		return this.dao.save(product);
	}
	
	public Product findProductById(int id) {
		Optional<Product> optional=this.dao.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	
	}
	
	public List<Product> getAllProduct(){
		return this.dao.findAll();
	}
	
	public Product updateProduct(Product product) {
		return this.dao.save(product);
	}
	
	public boolean deleteProduct(Product product) {
		boolean result = false;
		try {
			this.dao.delete(product);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
}
