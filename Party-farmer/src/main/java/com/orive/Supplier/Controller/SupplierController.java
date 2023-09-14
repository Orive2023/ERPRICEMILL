package com.orive.Supplier.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Supplier.Dto.SupplierDTo;
import com.orive.Supplier.Service.SupplierService;

@RestController
@RequestMapping(value = "/api/suppliers")
@CrossOrigin("http://localhost:3000")
public class SupplierController {
	
	private Logger logger=LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;
	
	// Create a new supplier
    @PostMapping("/create/supplier")
    public ResponseEntity<SupplierDTo> createSupplier(@RequestBody SupplierDTo supplierDTO) {
        SupplierDTo createdSupplier = supplierService.createSupplier(supplierDTO);
        logger.info("Created supplier with name: {}", createdSupplier.getBussinessOwnerName());
        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }

    // Get all suppliers
    @GetMapping("/get/suppliers")
    public ResponseEntity<List<SupplierDTo>> getAllSuppliers() {
        List<SupplierDTo> suppliers = supplierService.getAllSuppliers();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // Get supplier by ID
    @GetMapping("/get/{supplierId}")
    public ResponseEntity<SupplierDTo> getSupplierById(@PathVariable Long supplierId) {
        Optional<SupplierDTo> supplier = supplierService.getSupplierById(supplierId);
        if (supplier.isPresent()) {
            logger.info("Retrieved supplier with ID: {}", supplierId);
            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found", supplierId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update supplier by ID
    @PutMapping("/update/{supplierId}")
    public ResponseEntity<SupplierDTo> updateSupplier(@PathVariable Long supplierId, @RequestBody SupplierDTo updatedSupplierDTO) {
        SupplierDTo updatedSupplier = supplierService.updateSupplier(supplierId, updatedSupplierDTO);
        if (updatedSupplier != null) {
            logger.info("Updated supplier with ID: {}", supplierId);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found for update", supplierId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Update supplier by ID
    @PutMapping("/update/{businessOwnerName}")
    public ResponseEntity<SupplierDTo> updateSupplierName(@PathVariable String businessOwnerName, @RequestBody SupplierDTo updatedSupplierDTO) {
        SupplierDTo updatedSupplier = supplierService.updateSupplierName(businessOwnerName, updatedSupplierDTO);
        if (updatedSupplier != null) {
            logger.info("Updated supplier with name: {}", businessOwnerName);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            logger.warn("Supplier with name {} not found for update", businessOwnerName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete supplier by ID
    @DeleteMapping("/delete/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long supplierId) {
        supplierService.deleteSupplier(supplierId);
        logger.info("Deleted supplier with ID: {}", supplierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get suppliers by business owner name
    @GetMapping("/byBusinessOwner/{businessOwnerName}")
    public ResponseEntity<List<SupplierDTo>> getSuppliersByBusinessOwnerName(@PathVariable String businessOwnerName) {
        List<SupplierDTo> suppliers = supplierService.getSuppliersByBusinessOwnerName(businessOwnerName);
        if (!suppliers.isEmpty()) {
            logger.info("Retrieved {} suppliers with business owner name: {}", suppliers.size(), businessOwnerName);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } else {
            logger.warn("No suppliers found with business owner name: {}", businessOwnerName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	    
	    @GetMapping("/count/supplier")
	    public long countSupplier()
	    {
	    	return supplierService.countSupplier();
	    }
}
