package com.lab.swapper.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.UserRepository;
import com.lab.swapper.service.ItemService;
import com.lab.swapper.service.UserDetailsImpl;

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
	  public List<Item> getAllItems() {
	    return itemService.findAll();
	  }
	  
	  @GetMapping("/init")
	  public String init(Principal principal) {
		 User user= userRepository.findByUsername(principal.getName()).orElse(null);
		  itemService.init(user);
	    return "ok";
	  }

}
