package com.lab.swapper.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.CategoryRepository;
import com.lab.swapper.repository.UserRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	private CategoryRepository categoryService;

	public CategoryController(CategoryRepository categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
	
	@PostMapping("/")
	Category addCategory(@RequestBody Category category) {
	    return categoryService.save(category);
	}
	
	@GetMapping("/{id}")
	Optional<Category> findCategory(@PathVariable String id) {
		return categoryService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	void deleteCategory(@PathVariable String id) {
		categoryService.deleteById(id);
	}
}
