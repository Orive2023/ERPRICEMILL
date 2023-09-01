package com.orive.Supplier.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Supplier.Dto.SupplierDTo;
import com.orive.Supplier.Entity.SupplierDetails;
import com.orive.Supplier.Repository.SupplierRepositoy;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierService {
	
	private Logger logger=LoggerFactory.getLogger(SupplierService.class);

	@Autowired
	private SupplierRepositoy supplierRepositoy;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	 public SupplierDTo createSupplier(SupplierDTo mandi) {
		    logger.info("Creating a new supplier");
	        SupplierDetails mandiDetails = modelMapper.map(mandi, SupplierDetails.class);
	        SupplierDetails savedProduct = supplierRepositoy.save(mandiDetails);
	        return modelMapper.map(savedProduct, SupplierDTo.class);
	    }
	
	 public List<SupplierDTo> getAllSupplier() {
		 logger.info("Fetching all suppliers");	 
	        List<SupplierDetails> mandiDetails = supplierRepositoy.findAll();
	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, SupplierDTo.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<SupplierDTo> getSupplierById(List<Long> supplierId) {
		 logger.info("Fetching suppliers by IDs");
	        List<SupplierDetails> mandiDetails = supplierRepositoy.findAllById(supplierId);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, SupplierDTo.class))
	                       .collect(Collectors.toList());
	    }
	 
	 public List<SupplierDTo> getSupplierByName(String supplierName) {
		 logger.info("Fetching suppliers by name");
	        List<SupplierDetails> mandiDetails = supplierRepositoy.findBySupplierName(supplierName);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, SupplierDTo.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteSupplier(Long supplierId) {
		 logger.info("Deleting supplier by ID: {}", supplierId);
	        SupplierDetails existingMandi = supplierRepositoy.findById(supplierId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("supplierId not found"));

	        supplierRepositoy.delete(existingMandi);
	    }	
	 public SupplierDTo updateSupplier(Long supplierId, SupplierDTo updatedMandiDTO) {
		 logger.info("Updating supplier with ID: {}", supplierId);
	        SupplierDetails mandiDetails = supplierRepositoy.findById(supplierId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("supplierId not found"));

	        modelMapper.map(updatedMandiDTO, mandiDetails);

	        SupplierDetails updatedMandi = supplierRepositoy.save(mandiDetails);
	        return modelMapper.map(updatedMandi, SupplierDTo.class);
	    }
}
