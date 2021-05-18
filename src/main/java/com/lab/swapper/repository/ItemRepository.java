package com.lab.swapper.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;

public interface ItemRepository extends MongoRepository<Item, String> {
	
	List<Item> findByUser(User user);
	List<Item> findAll();
	List<Item> findByWarehouse(int warehouse);
	List<Item> findByUserAndWarehouse(User user, int warehouse);
	List<Item> findByUserNotAndWarehouse(User user, int warehouse);
	void deleteById(String id);
}
