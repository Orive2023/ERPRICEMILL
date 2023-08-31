package com.orive.ProductSummary.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.ProductSummary.Dto.Inventory;
import com.orive.ProductSummary.Entity.ProductSummaryDetails;
import com.orive.ProductSummary.Repository.ProductSummaryRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductSummaryService {

	private Logger logger=LoggerFactory.getLogger(ProductSummaryService.class);
	
	@Autowired
	private ProductSummaryRepository productSummaryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	 public Inventory createProduct(Inventory inventory) {
	        ProductSummaryDetails Details = modelMapper.map(inventory, ProductSummaryDetails.class);
	        ProductSummaryDetails savedProduct = productSummaryRepository.save(Details);
	        return modelMapper.map(savedProduct, Inventory.class);
	    }
	
	 public List<Inventory> getAllProducts() {
	        List<ProductSummaryDetails> Details = productSummaryRepository.findAll();
	        return Details.stream()
	                       .map(mandi -> modelMapper.map(mandi, Inventory.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Inventory> getProductById(List<Long> productSummaryId) {
	        List<ProductSummaryDetails> Details = productSummaryRepository.findAllById(productSummaryId);

	        return Details.stream()
	                       .map(mandi -> modelMapper.map(mandi, Inventory.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void delete(Long productSummaryId) {
	        ProductSummaryDetails existing = productSummaryRepository.findById(productSummaryId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("productSummaryId not found"));

	        productSummaryRepository.delete(existing);
	    }	
	 public Inventory update(Long productSummaryId, Inventory updatedDTO) {
	        ProductSummaryDetails Details = productSummaryRepository.findById(productSummaryId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("productSummaryId not found"));

	        modelMapper.map(updatedDTO, Details);

	        ProductSummaryDetails updated = productSummaryRepository.save(Details);
	        return modelMapper.map(updated, Inventory.class);
	    }
}
