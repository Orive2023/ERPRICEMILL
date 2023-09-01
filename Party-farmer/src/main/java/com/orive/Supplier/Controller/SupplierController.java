package com.orive.Supplier.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	private Logger logger=LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;
	
	    @PostMapping(value = "/save")
	    public ResponseEntity<SupplierDTo> createProduct(@RequestBody SupplierDTo mandi) {
	    	logger.info("Creating a new supplier");
	        SupplierDTo createdMandi = supplierService.createSupplier(mandi);
	        return new ResponseEntity<>(createdMandi, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<SupplierDTo>> getAllProducts() {
	    	 logger.info("Fetching all suppliers");
	        List<SupplierDTo> products = supplierService.getAllSupplier();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{supplierId}")
	    public ResponseEntity<List<SupplierDTo>> getProductsByIds(@PathVariable List<Long> supplierId) {
	    	logger.info("Fetching suppliers by IDs");
	        List<SupplierDTo> products = supplierService.getSupplierById(supplierId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PutMapping("/update/{supplierId}")
	    public ResponseEntity<SupplierDTo> updateProduct(
	            @PathVariable Long supplierId, @RequestBody SupplierDTo updatedMandiDTO) {
	    	logger.info("Updating supplier with ID: {}", supplierId);
	        SupplierDTo updatedMandi = supplierService.updateSupplier(supplierId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{supplierId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long supplierId) {
	    	logger.info("Deleting supplier with ID: {}", supplierId);
	        supplierService.deleteSupplier(supplierId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
