package com.orive.InventoryPurchase.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orive.InventoryPurchase.Entity.PaddyPurchase;
import com.orive.InventoryPurchase.Repository.PaddyPurchaseRepository;

@Service
public class PaddyPurchaseService {

	@Autowired
	private PaddyPurchaseRepository paddyPurchaseRepository;
	
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
	
	public Optional<PaddyPurchase> getById(Long paddyPurchaseId)
	{
		return paddyPurchaseRepository.findById(paddyPurchaseId);
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
