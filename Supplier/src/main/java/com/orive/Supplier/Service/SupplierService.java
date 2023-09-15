package com.orive.Supplier.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Supplier.Dto.SupplierDto;
import com.orive.Supplier.Entity.SupplierDetails;
import com.orive.Supplier.Repository.SupplierRepositoy;

@Service
public class SupplierService {
	
	private Logger logger=LoggerFactory.getLogger(SupplierService.class);

	@Autowired
	private SupplierRepositoy supplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

    // Create
    public SupplierDto createSupplier(SupplierDto supplierDTO) {
        SupplierDetails supplierEntity = convertToEntity(supplierDTO);
        SupplierDetails savedSupplier = supplierRepository.save(supplierEntity);
        logger.info("Created supplier with ID: {}", savedSupplier.getSupplierId());
        return convertToDTO(savedSupplier);
    }

    // Read
    public List<SupplierDto> getAllSuppliers() {
        List<SupplierDetails> suppliers = supplierRepository.findAll();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return suppliers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by supplierId
    public Optional<SupplierDto> getSupplierById(Long supplierId) {
        Optional<SupplierDetails> supplier = supplierRepository.findById(supplierId);
        if (supplier.isPresent()) {
            return Optional.of(convertToDTO(supplier.get()));
        } else {
            logger.warn("Supplier with ID {} not found", supplierId);
            return Optional.empty();
        }
    }
    
    
 // Fetch suppliers by businessOwnerName
    public List<SupplierDto> getSuppliersBySuppliername(String supplierName) {
        Optional<SupplierDetails> supplierOptional = supplierRepository.findBySupplierName(supplierName);
        if (supplierOptional.isPresent()) {
            SupplierDetails supplier = supplierOptional.get();
            List<SupplierDto> suppliers = supplierRepository.findBySupplierName(supplierName)
                    .stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            logger.info("Retrieved {} suppliers with business owner name: {}", suppliers.size(), supplierName);
            return suppliers;
        } else {
            logger.warn("No suppliers found with business owner name: {}", supplierName);
            return Collections.emptyList();
        }
    }

    // Update list by id
    public SupplierDto updateSupplier(Long supplierId, SupplierDto updatedSupplierDTO) {
        Optional<SupplierDetails> existingSupplierOptional = supplierRepository.findById(supplierId);
        if (existingSupplierOptional.isPresent()) {
            SupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            SupplierDetails updatedSupplier = supplierRepository.save(existingSupplier);
            logger.info("Updated supplier with ID: {}", updatedSupplier.getSupplierId());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with ID {} not found for update", supplierId);
            return null;
        }
    }
    
    //update list by name
    public SupplierDto updateSupplierName(String supplierName, SupplierDto updatedSupplierDTO) {
        Optional<SupplierDetails> existingSupplierOptional = supplierRepository.findBySupplierName(supplierName);
        if (existingSupplierOptional.isPresent()) {
            SupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            SupplierDetails updatedSupplier = supplierRepository.save(existingSupplier);
            logger.info("Updated supplier with name: {}", updatedSupplier.getSupplierName());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with name {} not found for update", supplierName);
            return null;
        }
    }


    // Delete
    public void deleteSupplier(Long supplierId) {
        supplierRepository.deleteById(supplierId);
        logger.info("Deleted supplier with ID: {}", supplierId);
    }

    //count the total supplierlist
    public long countSupplier()
	 {
		 return supplierRepository.count();
	 }
    
    
    // Helper method to convert SupplierDTo to SupplierDetails entity
    private SupplierDetails convertToEntity(SupplierDto supplierDTO) {
        return modelMapper.map(supplierDTO, SupplierDetails.class);
    }

    // Helper method to convert SupplierDetails entity to SupplierDTo
    private SupplierDto convertToDTO(SupplierDetails supplierDetails) {
        return modelMapper.map(supplierDetails, SupplierDto.class);
    }
    
    
	 
	
}
