package com.lab.swapper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	List<Category> findAll();
	Optional<Category> findByName(String name);
}
