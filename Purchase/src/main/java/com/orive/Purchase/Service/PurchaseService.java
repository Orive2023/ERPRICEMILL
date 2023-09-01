package com.orive.Purchase.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Purchase.Dto.ProductDto;
import com.orive.Purchase.Dto.PurchaseDto;
import com.orive.Purchase.Entity.ProductDetails;
import com.orive.Purchase.Entity.PurchaseDetails;
import com.orive.Purchase.Repository.PurchaseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PurchaseService {
	
	private Logger logger=LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public PurchaseDto createPurchase(PurchaseDto purchaseDto) {
	    PurchaseDetails gowdownDetails = modelMapper.map(purchaseDto, PurchaseDetails.class);

	    for (ProductDto godownProductDto : purchaseDto.getProductDto()) {
	        ProductDetails godownProductDetails = modelMapper.map(godownProductDto, ProductDetails.class);
	        godownProductDetails.setPurchaseDetails(gowdownDetails);
	        gowdownDetails.getProductDetails().add(godownProductDetails);
	    }

	    PurchaseDetails details = purchaseRepository.save(gowdownDetails);

	    return modelMapper.map(details, PurchaseDto.class);
	}
	
	 public List<PurchaseDto> getAllGowdown() {
	        List<PurchaseDetails> gowdownDetails = purchaseRepository.findAll();
	        return gowdownDetails.stream()
	                       .map(gowdown -> modelMapper.map(gowdown, PurchaseDto.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<PurchaseDto> getGodownById(List<Long> purchaseId) {
	        List<PurchaseDetails> gowdownDetails = purchaseRepository.findAllById(purchaseId);

	        return gowdownDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, PurchaseDto.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteGodown(Long purchaseId) {
	        PurchaseDetails existingGowdown = purchaseRepository.findById(purchaseId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("purchaseId not found"));

	        purchaseRepository.deleteById(purchaseId);
	    }	
	 public PurchaseDto updateGowdown(Long purchaseId, PurchaseDto updatedGodownDTO) {
	        PurchaseDetails Entity = purchaseRepository.findById(purchaseId)
	                .orElseThrow(() -> new EntityNotFoundException("purchaseId not found"));

	        Entity.setPurchaseDate(updatedGodownDTO.getPurchaseDate());
	        // Update other fields as needed
	        
	        // Update addresses
	        Entity.getProductDetails().clear();
	        for (ProductDto DTO : updatedGodownDTO.getProductDto()) {
	            ProductDetails productEntity = modelMapper.map(DTO, ProductDetails.class);
	            productEntity.setPurchaseDetails(Entity);
	            Entity.getProductDetails().add(productEntity);
	        }

	        PurchaseDetails updated = purchaseRepository.save(Entity);

	        return modelMapper.map(updated, PurchaseDto.class);
	    }
}
