package com.orive.PartyFarmer.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.PartyFarmer.Entity.Farmer;
import com.orive.PartyFarmer.Repository.FarmerRepository;

@Service
public class FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;
	
	
	public Farmer save(Farmer farmer)
	{
		return farmerRepository.save(farmer);
	}
	
	public List<Farmer> getAll()
	{
		return farmerRepository.findAll();
	}
	
	public Optional<Farmer> getById(Long farmerId)
	{
		Optional<Farmer> optional=farmerRepository.findById(farmerId);
		if(optional.isPresent())
		{
			return optional;
		}
		else
		{
			throw new NoSuchElementException("FarmerId not found");
		}
	}
	
	public void delete(Long farmerId)
	{
		farmerRepository.deleteById(farmerId);
	}
	
	public Farmer update(Long farmerId,Farmer  farmer)
	{
		Optional<Farmer> optional=farmerRepository.findById(farmerId);
		if(optional.isPresent())
		{
			Farmer farmer2=optional.get();
			farmer2.setFarmerName(farmer.getFarmerName());
			farmer2.setAddress(farmer.getAddress());
			farmer2.setFarmerName(farmer.getFarmerName());
			farmer2.setMobileNumber(farmer.getMobileNumber());
			Farmer farmer3=farmerRepository.save(farmer2);
			return farmer3;
	}else
	{
		throw new NoSuchElementException("Farmer Not Found");
	}
	
	}
}
