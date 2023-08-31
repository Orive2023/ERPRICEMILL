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

import com.orive.Supplier.Dto.Supplier;
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
	
	
	 public Supplier createProduct(Supplier mandi) {
	        SupplierDetails mandiDetails = modelMapper.map(mandi, SupplierDetails.class);
	        SupplierDetails savedProduct = supplierRepositoy.save(mandiDetails);
	        return modelMapper.map(savedProduct, Supplier.class);
	    }
	
	 public List<Supplier> getAllProducts() {
	        List<SupplierDetails> mandiDetails = supplierRepositoy.findAll();
	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Supplier.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Supplier> getMandiById(List<Long> mandiId) {
	        List<SupplierDetails> mandiDetails = supplierRepositoy.findAllById(mandiId);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Supplier.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteMandi(Long mandiId) {
	        SupplierDetails existingMandi = supplierRepositoy.findById(mandiId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Mandi not found"));

	        supplierRepositoy.delete(existingMandi);
	    }	
	 public Supplier updateMandi(Long mandiId, Supplier updatedMandiDTO) {
	        SupplierDetails mandiDetails = supplierRepositoy.findById(mandiId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Mandi not found"));

	        modelMapper.map(updatedMandiDTO, mandiDetails);

	        SupplierDetails updatedMandi = supplierRepositoy.save(mandiDetails);
	        return modelMapper.map(updatedMandi, Supplier.class);
	    }
}
