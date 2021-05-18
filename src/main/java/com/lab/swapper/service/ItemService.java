package com.lab.swapper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.FileInfo;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.CategoryRepository;
import com.lab.swapper.repository.ItemRepository;
import com.lab.swapper.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;

import payload.ItemResponse;

@Service
public class ItemService {
	
	private ItemRepository itemRepository;
	private CategoryRepository categoryRepository;
	private UserRepository userRepository;
	private SwapRequestService swapRequestService;
	public ItemService(ItemRepository itemRepository,CategoryRepository categoryRepository, UserRepository userRepository,
			SwapRequestService swapRequestService) {
		this.itemRepository = itemRepository;
		this.categoryRepository= categoryRepository;
		this.userRepository=userRepository;
		this.swapRequestService=swapRequestService;
		
	}
	
	public void init(User user) {
	//	categoryRepository.delete(new Category("noth"));
//		Category categoryPhone = categoryRepository.findByName("Phone").orElse(new Category("Others"));
//		itemRepository.save(new	Item(
//				"Phone1", categoryPhone,"just for test", 
//				"18-03-2021", "18-03-2021", 0, user));
//		itemRepository.save(new	Item(
//				"Phone2", categoryPhone,"just for test", 
//				"18-03-2021", "18-03-2021",0, user));
//		
//		Category categoryClothes = categoryRepository.findByName("Clothes").orElse(new Category("Others"));
//		itemRepository.save(new	Item(
//				"Clothes1", categoryClothes,"just for test", 
//				"18-03-2021", "18-03-2021",0, user));
//		itemRepository.save(new	Item(
//				"Clothes2", categoryClothes,"just for test", 
//				"18-03-2021", "18-03-2021",0, user));
//		
//		
//		Category categoryTools = categoryRepository.findByName("Tools").orElse(new Category("Others"));
//		itemRepository.save(new	Item(
//				"Tools1", categoryTools,"just for test", 
//				"18-03-2021", "18-03-2021",0, user));
//		itemRepository.save(new	Item(
//				"Tools2", categoryTools,"just for test", 
//				"18-03-2021", "18-03-2021",0, user));
	}
	public List<Item> findAll(){
		return itemRepository.findAll();
	}

	public void deleteAll() {
		itemRepository.deleteAll();
	}
	
	public Optional<Item> getItem(String id) {
		return itemRepository.findById(id);
	}
	
	public List<Item> findItemsByUser(User user){
		return itemRepository.findByUserAndWarehouse(user, 0);
	}
	
	public List<Item> findItemsByWarehouse(int a){
		return itemRepository.findByWarehouse(a);
	}

	public ItemResponse takeItem(String id, ItemResponse request) {
		Item item=itemRepository.findById(id).get();
		User user= userRepository.findById(request.getUserId()).get();
		item.setUser(user);
		item.setWarehouse(request.getWarehouse());
		itemRepository.save(item);
		return new ItemResponse(item.getId(),
				  item.getName(),
				  item.getCategory().getName(),
				  item.getDescription(),
				  item.getReleaseDate(),
				  item.getUser().getId(),
				  item.getUser().getUsername(),
				  item.getWarehouse(),
				  item.getFileInfo().getUrl());
	}

	public ItemResponse returnItem(String id) {
		Item item=itemRepository.findById(id).get();
		item.setWarehouse(1);
		itemRepository.save(item);
		swapRequestService.deleteAllRequestsOfItem(id);
		return new ItemResponse(item.getId(),
				  item.getName(),
				  item.getCategory().getName(),
				  item.getDescription(),
				  item.getReleaseDate(),
				  item.getUser().getId(),
				  item.getUser().getUsername(),
				  item.getWarehouse(),
				  item.getFileInfo().getUrl());
	}

	public Item addItem(ItemResponse request) {
		Category categoryTools = categoryRepository.findById(request.getCategory()).orElse(new Category("Others"));
		User user=userRepository.findById(request.getUserId()).get();
		return itemRepository.save(new	Item(
				request.getName(), categoryTools,request.getDescription(), 
				request.getReleaseDate(), request.getReleaseDate(),0, user, new FileInfo(request.getUrl().substring(28), request.getUrl())));
	}

	public void deleteById(String id) {
		itemRepository.deleteById(id);
		
	}

	public List<Item> findItemsUserNotAndWareHouse(User user, int i) {
		return itemRepository.findByUserNotAndWarehouse(user, i);
	}
}
