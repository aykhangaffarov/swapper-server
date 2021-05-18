package com.lab.swapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lab.swapper.model.Category;
import com.lab.swapper.model.Item;
import com.lab.swapper.model.SwapRequest;
import com.lab.swapper.model.User;
import com.lab.swapper.repository.CategoryRepository;
import com.lab.swapper.repository.ItemRepository;
import com.lab.swapper.repository.SwapRequestRepository;
import com.lab.swapper.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;

import payload.ItemResponse;
@Service
public class SwapRequestService {
	
	private SwapRequestRepository swapRequestRepository;
	private ItemRepository itemRepository;
	private UserRepository userRepository;
	
	public SwapRequestService(SwapRequestRepository swapRequestRepository,
								ItemRepository itemRepository,
								UserRepository userRepository) {
		this.swapRequestRepository = swapRequestRepository;
		this.itemRepository=itemRepository;
		this.userRepository=userRepository;
	}
	
	
	public List<SwapRequest> findSwapRequestsByRequestedItemId(String id){
		  List<SwapRequest> swaplist= swapRequestRepository.findByRequestedItemId(id);
//		  for(SwapRequest item: swaplist) {
//			  itemresponseList.add(new SwapRequestResponse(item.getId(),
//					  item.getRequestedItemId(),
//					  itemRepository.findById(item.getRequestedItemId()).orElseThrow().getName(),
//					  
//					  ));
//		  }
			return swaplist;
	}


	public SwapRequest save(SwapRequest request) {
		return swapRequestRepository.save(request);
	}


	public void delete(String id) {
		swapRequestRepository.deleteById(id);
	}


	public List<SwapRequest> findSwapRequestsByUserId(String id) {
		return swapRequestRepository.findBySwapUserId(id);
	}


	public void performSwapRequest(String id) {
		SwapRequest request=swapRequestRepository.findById(id).get();
		// change user of requested item
		Item requestedItem =itemRepository.findById(request.getRequestedItemId()).get();
		User swapUser=userRepository.findById(request.getSwapUserId()).get();
		requestedItem.setUser(swapUser);
		itemRepository.save(requestedItem);
		
		// change user of swapped item
		Item swapItem =itemRepository.findById(request.getSwapItemId()).get();
		User requestedUser=userRepository.findById(request.getRequestedUserId()).get();
		swapItem.setUser(requestedUser);
		itemRepository.save(swapItem);
		swapRequestRepository.deleteAllByRequestedItemId(requestedItem.getId());
		swapRequestRepository.deleteAllBySwapItemId(swapItem.getId());
		
	}
	
	public void deleteAllRequestsOfItem(String id) {
		swapRequestRepository.deleteAllByRequestedItemId(id);
		swapRequestRepository.deleteAllBySwapItemId(id);
	}
	
	
}
