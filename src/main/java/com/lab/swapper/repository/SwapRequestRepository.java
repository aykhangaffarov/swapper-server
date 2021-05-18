package com.lab.swapper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lab.swapper.model.SwapRequest;

public interface SwapRequestRepository extends MongoRepository<SwapRequest, String> {
	public List<SwapRequest> findByRequestedItemId(String requestedItemId);
	public List<SwapRequest> findBySwapUserId(String userId);
	public void deleteAllByRequestedItemId(String requestedItemId);
	public void deleteAllBySwapItemId(String swapItemId);
	
}
