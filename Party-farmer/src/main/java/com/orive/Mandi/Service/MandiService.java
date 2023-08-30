package com.orive.Mandi.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Mandi.Dto.Mandi;
import com.orive.Mandi.Entity.MandiDetails;
import com.orive.Mandi.Repository.MandiRepositoy;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MandiService {

	@Autowired
	private MandiRepositoy mandiRepositoy;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	 public Mandi createProduct(Mandi mandi) {
	        MandiDetails mandiDetails = modelMapper.map(mandi, MandiDetails.class);
	        MandiDetails savedProduct = mandiRepositoy.save(mandiDetails);
	        return modelMapper.map(savedProduct, Mandi.class);
	    }
	
	 public List<Mandi> getAllProducts() {
	        List<MandiDetails> mandiDetails = mandiRepositoy.findAll();
	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Mandi.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Mandi> getMandiById(List<Long> mandiId) {
	        List<MandiDetails> mandiDetails = mandiRepositoy.findAllById(mandiId);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Mandi.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteMandi(Long mandiId) {
	        MandiDetails existingMandi = mandiRepositoy.findById(mandiId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Mandi not found"));

	        mandiRepositoy.delete(existingMandi);
	    }	
	 public Mandi updateMandi(Long mandiId, Mandi updatedMandiDTO) {
	        MandiDetails mandiDetails = mandiRepositoy.findById(mandiId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Mandi not found"));

	        modelMapper.map(updatedMandiDTO, mandiDetails);

	        MandiDetails updatedMandi = mandiRepositoy.save(mandiDetails);
	        return modelMapper.map(updatedMandi, Mandi.class);
	    }
}
