package com.orive.Mandi.Controller;

import java.util.List;



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


import com.orive.Mandi.Service.MandiService;
import com.orive.Mandi.Dto.Mandi;

@RestController
@RequestMapping(value = "/mandi")
public class MandiController {

	@Autowired
	private MandiService mandiService;
	
	    @PostMapping(value = "/save")
	    public ResponseEntity<Mandi> createProduct(@RequestBody Mandi mandi) {
	        Mandi createdMandi = mandiService.createProduct(mandi);
	        return new ResponseEntity<>(createdMandi, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Mandi>> getAllProducts() {
	        List<Mandi> products = mandiService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{mandiId}")
	    public ResponseEntity<List<Mandi>> getProductsByIds(@PathVariable List<Long> mandiId) {
	        List<Mandi> products = mandiService.getMandiById(mandiId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PutMapping("/update/{mandiId}")
	    public ResponseEntity<Mandi> updateProduct(
	            @PathVariable Long mandiId, @RequestBody Mandi updatedMandiDTO) {
	        Mandi updatedMandi = mandiService.updateMandi(mandiId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{productId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long mandiId) {
	        mandiService.deleteMandi(mandiId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
