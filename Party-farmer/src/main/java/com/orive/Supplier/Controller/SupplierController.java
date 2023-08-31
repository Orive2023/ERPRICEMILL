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

import com.orive.Supplier.Dto.Supplier;
import com.orive.Supplier.Service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	private Logger logger=LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;
	
	    @PostMapping(value = "/save")
	    public ResponseEntity<Supplier> createProduct(@RequestBody Supplier mandi) {
	        Supplier createdMandi = supplierService.createProduct(mandi);
	        return new ResponseEntity<>(createdMandi, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Supplier>> getAllProducts() {
	        List<Supplier> products = supplierService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{supplierId}")
	    public ResponseEntity<List<Supplier>> getProductsByIds(@PathVariable List<Long> supplierId) {
	        List<Supplier> products = supplierService.getMandiById(supplierId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PutMapping("/update/{supplierId}")
	    public ResponseEntity<Supplier> updateProduct(
	            @PathVariable Long supplierId, @RequestBody Supplier updatedMandiDTO) {
	        Supplier updatedMandi = supplierService.updateMandi(supplierId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{supplierId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long supplierId) {
	        supplierService.deleteMandi(supplierId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
