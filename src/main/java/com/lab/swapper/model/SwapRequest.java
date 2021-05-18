package com.lab.swapper.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SwapRequest {
	
	@Id
	private String id;
	
	@NotBlank
	private String requestedItemId;
	
	@NotBlank
	private String requestedItemName;
	@NotBlank
	private String requestedUserId;
	
	private String swapItemId;
	
	private String swapItemName;
	@NotBlank
	private String swapUserId;
	@NotBlank
	private String swapUserName;
	
	@NotBlank
	private String accepted;
	
	public String getRequestedItemName() {
		return requestedItemName;
	}
	public void setRequestedItemName(String requestedItemName) {
		this.requestedItemName = requestedItemName;
	}
	public String getSwapItemName() {
		return swapItemName;
	}
	public void setSwapItemName(String swapItemName) {
		this.swapItemName = swapItemName;
	}
	public String getSwapUserName() {
		return swapUserName;
	}
	public void setSwapUserName(String swapUserName) {
		this.swapUserName = swapUserName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestedItemId() {
		return requestedItemId;
	}
	public void setRequestedItemId(String requestedItemId) {
		this.requestedItemId = requestedItemId;
	}
	public String getRequestedUserId() {
		return requestedUserId;
	}
	public void setRequestedUserId(String requestedUserId) {
		this.requestedUserId = requestedUserId;
	}
	public String getSwapItemId() {
		return swapItemId;
	}
	public void setSwapItemId(String swapItemId) {
		this.swapItemId = swapItemId;
	}
	public String getSwapUserId() {
		return swapUserId;
	}
	public void setSwapUserId(String swapUserId) {
		this.swapUserId = swapUserId;
	}
	
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	
	
	public SwapRequest(@NotBlank String requestedItemId, @NotBlank String requestedItemName,
			@NotBlank String requestedUserId, String swapItemId, String swapItemName, @NotBlank String swapUserId,
			@NotBlank String swapUserName, @NotBlank String accepted) {
		super();
		this.requestedItemId = requestedItemId;
		this.requestedItemName = requestedItemName;
		this.requestedUserId = requestedUserId;
		this.swapItemId = swapItemId;
		this.swapItemName = swapItemName;
		this.swapUserId = swapUserId;
		this.swapUserName = swapUserName;
		this.accepted = accepted;
	}
	public SwapRequest() {
		
	}
	
	
}
