package com.app.main.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.entity.Product;
import com.app.main.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
	}
	
	@GetMapping("/getAll")
	public List<Product> getAllIProducts(){
		return productService.getAllProducts();
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id){
		Optional<Product> product = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
	
	@PutMapping("/reduseQuantity/{id}")
	public ResponseEntity<Void>  reduseQuantity(@PathVariable("id") int productId,
			@RequestParam int quantity){
		productService.reduseQuantity(productId,quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
