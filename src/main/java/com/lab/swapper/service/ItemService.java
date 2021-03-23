package com.lab.swapper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.CategoryRepository;
import com.lab.swapper.repository.ItemRepository;
import com.sun.security.auth.UserPrincipal;

@Service
public class ItemService {
	
	private ItemRepository itemRepository;
	private CategoryRepository categoryRepository;

	public ItemService(ItemRepository itemRepository,CategoryRepository categoryRepository) {
		this.itemRepository = itemRepository;
		this.categoryRepository= categoryRepository;
	}
	
	public void init(User user) {
	//	categoryRepository.delete(new Category("noth"));
		//categoryRepository.save(new Category("noth"));
		Category category = categoryRepository.findByName("noth").orElse(null);
		itemRepository.save(new	Item(
				"test1", category,"just for test", 
				"18-03-2021", "18-03-2021", user));
		itemRepository.save(new	Item(
				"test2", category,"just for test", 
				"18-03-2021", "18-03-2021", user));
		
		
	}
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	
	
}
