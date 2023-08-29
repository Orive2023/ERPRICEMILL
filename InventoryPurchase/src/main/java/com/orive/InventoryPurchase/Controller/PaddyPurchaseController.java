package com.orive.InventoryPurchase.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.InventoryPurchase.Entity.PaddyPurchase;
import com.orive.InventoryPurchase.Service.PaddyPurchaseService;

@RestController
@RequestMapping(value = "/purchase")
public class PaddyPurchaseController {

	@Autowired
	private PaddyPurchaseService paddyPurchaseService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> save(@RequestBody PaddyPurchase paddyPurchase)
	{
		
		paddyPurchaseService.save(paddyPurchase);
		return ResponseEntity.ok("PaddyPurchasse saves succesfully");
		
	}
	
	@GetMapping(value = "/get")
	public List<PaddyPurchase> get()
	{
		return paddyPurchaseService.get();
	}
	
	@GetMapping(value = "/getbyid/{paddyPurchaseId}")
	public Optional<PaddyPurchase> getById(@PathVariable("paddyPurcahseId") Long paddyPurchaseId)
	{
		return paddyPurchaseService.getById(paddyPurchaseId);
	}
	
	@DeleteMapping(value = "/delete/{paddyPurchaseId}")
	public void delete(@PathVariable("paddyPurchaseId") Long paddyPurchaseId)
	{
		paddyPurchaseService.delete(paddyPurchaseId);
	}
	
	@GetMapping(value = "/get/{rstNumber}/{rstDetails}")
	public Optional<PaddyPurchase> getByRst(@PathVariable("rstNumber") String rstNumber,@PathVariable("rstDetails") String rstDetails)
	{
		return paddyPurchaseService.getByRst(rstNumber, rstDetails);
	}
}
