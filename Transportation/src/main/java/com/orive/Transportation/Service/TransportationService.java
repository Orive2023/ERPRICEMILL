package com.orive.Transportation.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Transportation.Dto.Transportation;
import com.orive.Transportation.Entity.TransportationDetails;
import com.orive.Transportation.Repository.TransportationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransportationService {

	@Autowired
	private TransportationRepository transportationRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Transportation createTransportationDetails(Transportation transportation) {
        TransportationDetails transportationDetails = modelMapper.map(transportation, TransportationDetails.class);
        TransportationDetails savedProduct = transportationRepository.save(transportationDetails);
        return modelMapper.map(savedProduct, Transportation.class);
    }

 public List<Transportation> getAllTransportation() {
        List<TransportationDetails> transportationDetails = transportationRepository.findAll();
        return transportationDetails.stream()
                       .map(trans -> modelMapper.map(trans, Transportation.class))
                       .collect(Collectors.toList());
    }

 public List<Transportation> getTransportationById(List<Long> transportationId) {
        List<TransportationDetails> transportationDetails = transportationRepository.findAllById(transportationId);

        return transportationDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, Transportation.class))
                       .collect(Collectors.toList());
    }

 public void deleteTransportation(Long transportationId) {
        TransportationDetails transportationDetails = transportationRepository.findById(transportationId)
                                                  .orElseThrow(() -> new EntityNotFoundException("TransportationDetails not found"));

        transportationRepository.delete(transportationDetails);
    }
 
     public Transportation updateTransportation(Long transportationId, Transportation updatedDTO) {
        TransportationDetails transportationDetails = transportationRepository.findById(transportationId)
                                                  .orElseThrow(() -> new EntityNotFoundException("TransportationDetails not found"));

        modelMapper.map(updatedDTO, transportationDetails);

        TransportationDetails updated = transportationRepository.save(transportationDetails);
        return modelMapper.map(updated, Transportation.class);
    }
}
