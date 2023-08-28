package com.orive.InventoryStock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.InventoryStock.Entity.WasteMaterial;
import com.orive.InventoryStock.Repository.WasteMaterialRepository;

@Service
public class WasteMaterialService {

	@Autowired
	private WasteMaterialRepository wasteMaterialRepository;
	
	public WasteMaterial save(WasteMaterial wasteMaterial)
	{
		return wasteMaterialRepository.save(wasteMaterial);
	}
	
	public List<WasteMaterial> get()
	{
		return wasteMaterialRepository.findAll();
	}
	
	public Optional<WasteMaterial> getById(Long wasteMaterialId)
	{
		return wasteMaterialRepository.findById(wasteMaterialId);
	}
	
	public void delete(Long wasteMaterialId)
	{
		wasteMaterialRepository.deleteById(wasteMaterialId);
	}
}
