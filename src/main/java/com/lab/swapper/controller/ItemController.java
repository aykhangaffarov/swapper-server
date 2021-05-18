package com.lab.swapper.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.SwapRequest;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.UserRepository;
import com.lab.swapper.service.ItemService;
import com.lab.swapper.service.UserDetailsImpl;

import payload.ItemResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {
	private ItemService itemService;
	private UserRepository userRepository;
	ItemController(ItemService itemService, UserRepository userRepository) {
		this.itemService = itemService;
		this.userRepository=userRepository;
	}

	  @GetMapping("/")
	  public List<ItemResponse> getAllItems(Principal principal) {
		  User user= userRepository.findByUsername(principal.getName()).orElse(null);
		  List<Item> listItem=itemService.findItemsUserNotAndWareHouse(user,0);
		  List<ItemResponse> results=new ArrayList();
		  for(Item item:listItem) {
			  ItemResponse e=new ItemResponse(item.getId(),
					  item.getName(),
					  item.getCategory().getName(),
					  item.getDescription(),
					  item.getReleaseDate(),
					  item.getUser().getId(),
					  item.getUser().getUsername(),
					  item.getWarehouse(),
					  item.getFileInfo().getUrl());
			  results.add(e);
		  }
		  
	    return results;
	  }
	  
	  @GetMapping("/warehouse")
	  public List<ItemResponse> getAllWarehouseItems() {
		  List<Item> listItem=itemService.findItemsByWarehouse(1);
		  List<ItemResponse> results=new ArrayList();
		  for(Item item:listItem) {
			  ItemResponse e=new ItemResponse(item.getId(),
					  item.getName(),
					  item.getCategory().getName(),
					  item.getDescription(),
					  item.getReleaseDate(),
					  item.getUser().getId(),
					  item.getUser().getUsername(),
					  item.getWarehouse(),
					  item.getFileInfo().getUrl());
			  results.add(e);
		  }
		  
	    return results;
	  }
	  
	  @GetMapping("/init")
	  public String init(Principal principal) {
		 User user= userRepository.findByUsername(principal.getName()).orElse(null);
		  itemService.init(user);
	    return "ok";
	  }
	  
	  @DeleteMapping("/all")
	  public void deleteAll() {
		itemService.deleteAll();
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteAll(@PathVariable String id) {
		try {
			itemService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }
	  
	  @GetMapping("/{id}")
	  ItemResponse findItem(@PathVariable String id) {
			Item item=itemService.getItem(id).orElseThrow();
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
	  
	  @GetMapping("/userId/{id}")
	  List<ItemResponse> findItembyUser(@PathVariable String id) {
		  User user= userRepository.findById(id).orElseThrow();
		  List<Item> itemlist= itemService.findItemsByUser(user);
		  List<ItemResponse> itemresponseList=new ArrayList<>();
		  for(Item item: itemlist) {
			  itemresponseList.add(new ItemResponse(item.getId(),
					  item.getName(),
					  item.getCategory().getName(),
					  item.getDescription(),
					  item.getReleaseDate(),
					  item.getUser().getId(),
					  item.getUser().getUsername(),
					  item.getWarehouse(),
					  item.getFileInfo().getUrl()));
		  }
			return itemresponseList;
		  
		}
	  
	  @PutMapping("/take/{id}")
	  public ItemResponse takeItem(@RequestBody ItemResponse request, @PathVariable String id) {
		return itemService.takeItem(id, request);
	  }

	  @GetMapping("/sendwh/{id}")
	  public ItemResponse returnItem(@PathVariable String id) {
		return itemService.returnItem(id);
	  }
	  
	  @PostMapping("/")
	  public Item addItem(@RequestBody ItemResponse request) {
		  return itemService.addItem(request);
	  }
}
