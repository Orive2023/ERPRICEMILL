package com.orive.PartyFarmer.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.PartyFarmer.Entity.Farmer;
import com.orive.PartyFarmer.Service.FarmerService;

@RestController
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	@PostMapping(value = "/save")
	public Farmer save(@RequestBody Farmer farmer)
	{
		return farmerService.save(farmer);
	}
	
	@GetMapping(value = "/get")
	public List<Farmer> getAll()
	{
		return farmerService.getAll();
	}
	@GetMapping(value = "/getbyid/{farmerId}")
	public Optional<Farmer> getById(@PathVariable("farmerId") Long farmerId)
	{
		return farmerService.getById(farmerId);
	}
	@DeleteMapping(value = "/delete/{farmerId}")
	public void delete(@PathVariable("farmerId") Long farmerId)
	{
		farmerService.delete(farmerId);
	}
	
	@PutMapping(value = "/update/{farmerId}")
	public Farmer update(@PathVariable("farmerId") Long farmerId,@RequestBody Farmer  farmer)
	{
		return farmerService.update(farmerId, farmer);
	}

}
