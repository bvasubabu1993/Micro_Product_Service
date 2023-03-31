package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.main.dao.ProductRepository;
import com.app.main.entity.Product;
import com.app.main.exception.ProductServiceException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		product.orElseThrow(() -> new ProductServiceException("Product with given id is not found", "PRODUCT_NOT_FOUND"));
		return product;
		
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public void reduseQuantity(int productId, int quantity) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product with given id is not found", "PRODUCT_NOT_FOUND"));
		
		if(product.getQuantity() <quantity) {
			throw new ProductServiceException("Product have does not have a sufficient Quantity", "INSUFFICIENT_QUANTITY");
		}
		
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
	}

}