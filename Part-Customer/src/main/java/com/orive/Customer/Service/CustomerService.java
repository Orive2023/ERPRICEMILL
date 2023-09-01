package com.orive.Customer.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Customer.Dto.CustomerDto;
import com.orive.Customer.Entity.CustomerDetails;
import com.orive.Customer.Repository.CustomerRepository;


import jakarta.persistence.EntityNotFoundException;


@Service
public class CustomerService {
	
	private Logger logger=LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CustomerDto createCustomer(CustomerDto customer) {
	    logger.info("Creating a new customer");
        CustomerDetails customerDetails = modelMapper.map(customer, CustomerDetails.class);
        CustomerDetails savedProduct = customerRepository.save(customerDetails);
        return modelMapper.map(savedProduct, CustomerDto.class);
    }

    public List<CustomerDto> getAllCustomer() {
	 logger.info("Fetching all customers");	 
        List<CustomerDetails> mandiDetails = customerRepository.findAll();
        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, CustomerDto.class))
                       .collect(Collectors.toList());
    }

    public List<CustomerDto> getCustomerById(List<Long> customerId) {
	 logger.info("Fetchin  customers by IDs");
        List<CustomerDetails> mandiDetails = customerRepository.findAllById(customerId);

        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, CustomerDto.class))
                       .collect(Collectors.toList());
    }

    public void deleteCustomer(Long customerId) {
	 logger.info("Deleting customer by ID: {}", customerId);
        CustomerDetails existingMandi = customerRepository.findById(customerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        customerRepository.delete(existingMandi);
    }	
    
    public CustomerDto updateCustomer(Long customerId, CustomerDto updatedMandiDTO) {
	 logger.info("Updating supplier with ID: {}", customerId);
        CustomerDetails mandiDetails = customerRepository.findById(customerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        modelMapper.map(updatedMandiDTO, mandiDetails);

        CustomerDetails updatedMandi = customerRepository.save(mandiDetails);
        return modelMapper.map(updatedMandi, CustomerDto.class);
    }
}
