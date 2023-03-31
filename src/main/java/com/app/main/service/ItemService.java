package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.main.dao.ItemRepository;
import com.app.main.entity.Item;
import com.app.main.exception.ItemServiceException;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Optional<Item> getItemById(int id) {
		Optional<Item> item = itemRepository.findById(id);
		item.orElseThrow(() -> new ItemServiceException("Product with given id is not found", "PRODUCT_NOT_FOUND"));
		return item;
		
	}
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}

	public void reduseQuantity(int productId, int quantity) {
		Item product = itemRepository.findById(productId)
				.orElseThrow(() -> new ItemServiceException("Product with given id is not found", "PRODUCT_NOT_FOUND"));
		
		if(product.getQuantity() <quantity) {
			throw new ItemServiceException("Product have does not have a sufficient Quantity", "INSUFFICIENT_QUANTITY");
		}
		
		product.setQuantity(product.getQuantity()-quantity);
		itemRepository.save(product);
	}

}
