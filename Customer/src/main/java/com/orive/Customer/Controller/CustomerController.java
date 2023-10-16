package com.orive.Customer.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Customer.Dto.CustomerDto;
import com.orive.Customer.Service.CustomerService;

import jakarta.ws.rs.NotFoundException;


@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
	
	private Logger logger=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	 @PostMapping(value = "/save/customer")
	    public ResponseEntity<CustomerDto> createSupplier(@RequestBody CustomerDto mandi) {
	    	logger.info("Creating a new Customer");
	        CustomerDto created = customerService.createCustomer(mandi);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get/customer")
	    public ResponseEntity<List<CustomerDto>> getAllProducts() {
	    	 logger.info("Fetching all Customers");
	        List<CustomerDto> products = customerService.getAllCustomer();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{customerId}")
	    public ResponseEntity<List<CustomerDto>> getProductsByIds(@PathVariable List<Long> customerId) {
	    	logger.info("Fetching customers by IDs");
	        List<CustomerDto> products = customerService.getCustomerById(customerId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	    
	    @GetMapping("/customerName")
	    public ResponseEntity<List<CustomerDto>> getCustomersByBusinessOwnerName(
	            @RequestParam("customerName") String customerName) {
	        List<CustomerDto> customers = customerService.getByCustomerName(customerName);
	        if (!customers.isEmpty()) {
	            return new ResponseEntity<>(customers, HttpStatus.OK);
	        } else {
	            throw new NotFoundException("No customers found with business owner name: " + customerName);
	        }
	    }

	    @PutMapping("/update/{customerId}")
	    public ResponseEntity<CustomerDto> updateProduct(
	            @PathVariable Long customerId, @RequestBody CustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with ID: {}", customerId);
	        CustomerDto updatedMandi = customerService.updateCustomer(customerId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }
	    
	    @PutMapping("/update/{customerName}")
	    public ResponseEntity<CustomerDto> updateProduct(
	            @PathVariable String customerName, @RequestBody CustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with name: {}", customerName);
	        CustomerDto updatedMandi = customerService.updateCustomer(customerName, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{customerId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long customerId) {
	    	logger.info("Deleting customer with ID: {}", customerId);
	        customerService.deleteCustomer(customerId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @GetMapping("/count/customer")
	    public long countCustomer()
	    {
	    	return customerService.countCustomer();
	    }
}
