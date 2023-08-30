package com.orive.Gowdown.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Gowdown.Dto.Gowdown;
import com.orive.Gowdown.Entity.GowdownDetails;
import com.orive.Gowdown.Repository.GowdownRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class GowdownService {

	@Autowired
	private GowdownRepository gowdownRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	 public Gowdown createGowdown(Gowdown gowdown) {
	        GowdownDetails gowdownDetails = modelMapper.map(gowdown, GowdownDetails.class);
	        GowdownDetails details = gowdownRepository.save(gowdownDetails);
	        return modelMapper.map(details, Gowdown.class);
	    }
	
	 public List<Gowdown> getAllGowdown() {
	        List<GowdownDetails> gowdownDetails = gowdownRepository.findAll();
	        return gowdownDetails.stream()
	                       .map(gowdown -> modelMapper.map(gowdown, Gowdown.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Gowdown> getGodownById(List<Long> godownId) {
	        List<GowdownDetails> gowdownDetails = gowdownRepository.findAllById(godownId);

	        return gowdownDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Gowdown.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteGodown(Long godownId) {
	        GowdownDetails existingGowdown = gowdownRepository.findById(godownId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("godownId not found"));

	        gowdownRepository.deleteById(godownId);
	    }	
	 public Gowdown updateGowdown(Long godownId, Gowdown updatedGowdownDTO) {
	        GowdownDetails godownDetails = gowdownRepository.findById(godownId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("godownId not found"));

	        modelMapper.map(updatedGowdownDTO, godownDetails);

	        GowdownDetails updated = gowdownRepository.save(godownDetails);
	        return modelMapper.map(updated, Gowdown.class);
	    }
}
