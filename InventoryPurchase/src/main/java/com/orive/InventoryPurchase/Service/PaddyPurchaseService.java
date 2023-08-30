package com.orive.InventoryPurchase.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orive.InventoryPurchase.Controller.PaddyPurchaseController;
import com.orive.InventoryPurchase.Entity.Farmer;
import com.orive.InventoryPurchase.Entity.PaddyPurchase;
import com.orive.InventoryPurchase.Repository.PaddyPurchaseRepository;

@Service
public class PaddyPurchaseService {
	
	private Logger logger=LoggerFactory.getLogger(PaddyPurchaseService.class);

	@Autowired
	private PaddyPurchaseRepository paddyPurchaseRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public PaddyPurchase save(PaddyPurchase paddyPurchase)
	{
		paddyPurchase.calculateTotalNoOfPkts();
		paddyPurchase.calculateNetWeight();
		paddyPurchase.calculateTotalNoOfGunny();
		paddyPurchase.calculateAvgWtPerPkt();
		paddyPurchase.calculateTotalAmount();
		paddyPurchase.calculateTotal();
		paddyPurchase.calculateLabourCharge();
		return paddyPurchaseRepository.save(paddyPurchase);
	}
	
	public List<PaddyPurchase> get()
	{
		return paddyPurchaseRepository.findAll();
	}
	
	public PaddyPurchase getById(Long paddyPurchaseId)
	{
		PaddyPurchase paddyPurchase=paddyPurchaseRepository.findById(paddyPurchaseId).orElse(null);
		if(paddyPurchase!=null)
		{
			Farmer farmer=restTemplate.getForObject("http://localhost:8081/farmer/getbyid/"+paddyPurchase.getPaddyPurchaseId(), Farmer.class);
			logger.info("{} "+farmer);
			paddyPurchase.setFarmer(farmer);
		}
		return paddyPurchase;
	}
	
	public void delete(Long paddyPurchaseId)
	{
		paddyPurchaseRepository.deleteById(paddyPurchaseId);
	}
	
	public Optional<PaddyPurchase> getByRst(String rstNumber,String rstDetails)
	{
		return paddyPurchaseRepository.findByRstNumberAndRstDetails(rstNumber, rstDetails);
	}
}
