package com.app.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.CompletionContext.Status;
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

import com.app.main.entity.Item;
import com.app.main.service.ItemService;

@RestController
@RequestMapping(value = "/product")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/save")
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
		
	}
	
	@GetMapping("/getAll")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Item>> getItemById(@PathVariable int id){
		Optional<Item> item = itemService.getItemById(id);
		return ResponseEntity.status(HttpStatus.OK).body(item);
		
	}
	
	@PutMapping("/reduseQuantity/{id}")
	public ResponseEntity<Void>  reduseQuantity(@PathVariable("id") int productId,
			@RequestParam int quantity){
		itemService.reduseQuantity(productId,quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
