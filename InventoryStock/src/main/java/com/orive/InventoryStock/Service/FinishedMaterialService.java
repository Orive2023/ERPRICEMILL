package com.orive.InventoryStock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.InventoryStock.Entity.FinishedMaterial;
import com.orive.InventoryStock.Repository.FinishedMaterialRepository;

@Service
public class FinishedMaterialService {

	@Autowired
	private FinishedMaterialRepository finishedMaterialRepository;
	
	public FinishedMaterial save(FinishedMaterial finishedMaterial)
	{
		return finishedMaterialRepository.save(finishedMaterial);
	}
	
	public List<FinishedMaterial> get()
	{
		return finishedMaterialRepository.findAll();
	}
	
	public Optional<FinishedMaterial> getyById(Long finishedMaterialId)
	{
		return finishedMaterialRepository.findById(finishedMaterialId);
	}
	
	public void delete(Long finishedMaterialId)
	{
		finishedMaterialRepository.deleteById(finishedMaterialId);
	}
}
