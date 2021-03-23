package com.lab.swapper.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@DBRef
	private Category category;
	
	private String description;
	
	private String releaseDate;
	@NotBlank
	private String createdAt;
	
	@DBRef
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public Item(String name, Category category, String description, String releaseDate, String createdAt, User user) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.releaseDate = releaseDate;
		this.createdAt = createdAt;
		this.user=user;
	}
	
	public Item() {
		
	}
}
