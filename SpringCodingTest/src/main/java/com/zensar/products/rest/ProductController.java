package com.zensar.products.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.zensar.products.bean.Product;
import com.zensar.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value="/product")
	public Product registerProduct(@RequestBody Product product) {
		return this.service.addProduct(product);
	}

	@GetMapping("/findProductById/{pid}")
	public Product findProductById(@PathVariable(name="pid") int id) {
		return this.service.findProductById(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@PutMapping("/product/{pid}")
	public Product editProduct(@RequestBody Product product,
			@PathVariable(name = "pid") int id) {
		
		Product product2=this.service.findProductById(id);
		
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		product2.setDiscountPercentage(product.getDiscountPercentage());
		product2.setDescription(product.getDescription());
		
		return this.service.updateProduct(product2);
	}
	
	
	@DeleteMapping("/product/{pid}")
	public boolean f5(@PathVariable(name="pid")int productId) {
		
		Product product = this.service.findProductById(productId);
		
		boolean result = this.service.deleteProduct(product);
		
		
		return result;
	}
}
