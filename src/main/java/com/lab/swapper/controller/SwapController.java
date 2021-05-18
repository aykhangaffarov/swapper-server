package com.lab.swapper.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.lab.swapper.model.SwapRequest;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.CategoryRepository;
import com.lab.swapper.repository.UserRepository;
import com.lab.swapper.service.SwapRequestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/swaps")
public class SwapController {
	
	private  SwapRequestService swapRequestService;

	public SwapController(SwapRequestService swapRequestService) {
		this.swapRequestService = swapRequestService;
	}
	
	
	@GetMapping("/requesteditem/{id}")
	List<SwapRequest> findRequestedItems(@PathVariable String id) {
		return swapRequestService.findSwapRequestsByRequestedItemId(id);
	}
	
	@GetMapping("/confirm/{id}")
	ResponseEntity<HttpStatus> performSwap(@PathVariable String id) {
		try {
			swapRequestService.performSwapRequest(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}

	@PostMapping("/")
	SwapRequest addSwapRequest(@RequestBody SwapRequest request) {
	    return swapRequestService.save(request);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<HttpStatus> deleteSwapRequest(@PathVariable String id) {
	    try {
	    	swapRequestService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	
	@GetMapping("/myrequests/{id}")
	List<SwapRequest> findMyRequests(@PathVariable String id) {
		return swapRequestService.findSwapRequestsByUserId(id);
	}
	
}
