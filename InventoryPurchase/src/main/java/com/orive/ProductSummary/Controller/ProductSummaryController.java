package com.orive.ProductSummary.Controller;

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

import com.orive.ProductSummary.Dto.ProductSummary;
import com.orive.ProductSummary.Service.ProductSummaryService;


@RestController
@RequestMapping(value = "/productSummary")
public class ProductSummaryController {

	private Logger logger=LoggerFactory.getLogger(ProductSummaryController.class);
	
	@Autowired
	private ProductSummaryService productSummaryService;
	
	 @PostMapping(value = "/save")
	    public ResponseEntity<ProductSummary> createProduct(@RequestBody ProductSummary inventory) {
	        ProductSummary created = productSummaryService.createProduct(inventory);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<ProductSummary>> getAllProducts() {
	        List<ProductSummary> products = productSummaryService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{productSummaryId}")
	    public ResponseEntity<List<ProductSummary>> getProductsByIds(@PathVariable List<Long> productSummaryId) {
	        List<ProductSummary> products = productSummaryService.getProductById(productSummaryId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PutMapping("/update/{productSummaryId}")
	    public ResponseEntity<ProductSummary> updateProduct(
	            @PathVariable Long productSummaryId, @RequestBody ProductSummary updatedDTO) {
	        ProductSummary updated = productSummaryService.update(productSummaryId, updatedDTO);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{productSummaryId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long productSummaryId) {
	        productSummaryService.delete(productSummaryId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @PostMapping(value = "/inventory")
	    public String inventoryRequest(@RequestBody ProductSummary inventory)
	    {
	    	return productSummaryService.processInventoryRequest(inventory);
	    }
}
