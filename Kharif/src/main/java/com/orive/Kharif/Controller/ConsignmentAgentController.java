package com.orive.Kharif.Controller;

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

import com.orive.Kharif.Dto.ConsignmentAgentDto;
import com.orive.Kharif.Service.ConsignmentAgentService;



@RestController
@RequestMapping(value = "/consignmentagent")
@CrossOrigin("*")
public class ConsignmentAgentController {
	
private static final Logger logger=LoggerFactory.getLogger(ConsignmentAgentController.class); 
	
	@Autowired
	private ConsignmentAgentService consignmentAgentService  ;
	
	
	//API FOR ConsignmentAgent
	// Create a new ConsignmentAgent
    @PostMapping("/create/consignmentagent")
    public ResponseEntity<ConsignmentAgentDto> createConsignmentAgent(@RequestBody ConsignmentAgentDto consignmentAgentDto) {
    	ConsignmentAgentDto createdConsignmentAgent = consignmentAgentService.createConsignmentAgent(consignmentAgentDto);
        logger.info("Created ConsignmentAgent with name: {}", createdConsignmentAgent.getConsignmentAgentId());
        return new ResponseEntity<>(createdConsignmentAgent, HttpStatus.CREATED);
    }

    // Get all ConsignmentAgent
    
    @GetMapping("/get/consignmentagent")
    public ResponseEntity<List<ConsignmentAgentDto>> getAllConsignmentAgents() {
        List<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getAllConsignmentAgents();
        logger.info("Retrieved {} ConsignmentAgent from the database", consignmentAgent.size());
        return new ResponseEntity<>(consignmentAgent, HttpStatus.OK);
    }

    // Get ConsignmentAgent by ID
    @GetMapping("/get/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> getConsignmentAgentById(@PathVariable Long consignmentAgentId) {
        Optional<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getConsignmentAgentId(consignmentAgentId);
        if (consignmentAgent.isPresent()) {
            logger.info("Retrieved ConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(consignmentAgent.get(), HttpStatus.OK);
        } else {
            logger.warn("ConsignmentAgent with ID {} not found", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update ConsignmentAgent by ID
    @PutMapping("/update/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> updateConsignmentAgent(@PathVariable Long consignmentAgentId, @RequestBody ConsignmentAgentDto updatedConsignmentAgentDto) {
    	ConsignmentAgentDto updatedConsignmentAgent = consignmentAgentService.updateConsignmentAgent(consignmentAgentId, updatedConsignmentAgentDto);
        if (updatedConsignmentAgent != null) {
            logger.info("Updated ConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(updatedConsignmentAgent, HttpStatus.OK);
        } else {
            logger.warn("ConsignmentAgent with ID {} not found for update", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete ConsignmentAgent by ID
    @DeleteMapping("/delete/{consignmentagentId}")
    public ResponseEntity<Void> deleteConsignmentAgent(@PathVariable Long consignmentAgentId) {
        consignmentAgentService.deleteConsignmentAgent(consignmentAgentId);
        logger.info("Deleted ConsignmentAgent with ID: {}", consignmentAgentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/consignmentagent")
	    public long countConsignmentAgent()
	    {
	    	return consignmentAgentService.countConsignmentAgent();
	    }

}
