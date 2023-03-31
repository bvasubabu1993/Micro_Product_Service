package com.app.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.main.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
