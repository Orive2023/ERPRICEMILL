package com.orive.InventoryStock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.orive.InventoryStock.Entity.RawMaterial;
import com.orive.InventoryStock.Repository.RawMaterialRepository;

@Service
public class RawMaterialService {

	@Autowired
	private RawMaterialRepository rawMaterialRepository;
	
	public RawMaterial save(RawMaterial rawMaterial)
	{
		return rawMaterialRepository.save(rawMaterial);
	}
	
	public List<RawMaterial> get()
	{
		return rawMaterialRepository.findAll();
	}
	
	public Optional<RawMaterial> getById(Long rawMaterialId)
	{
		return rawMaterialRepository.findById(rawMaterialId);
	}
	
	public void delete(Long rawMaterialId)
	{
		rawMaterialRepository.deleteById(rawMaterialId);
	}
}
