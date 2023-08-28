package com.orive.InventoryStock.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.InventoryStock.Entity.FinishedMaterial;
import com.orive.InventoryStock.Service.FinishedMaterialService;

import jakarta.ws.rs.POST;

@RestController
@RequestMapping(value = "/finishedmaterial")
public class FinishedMaterialController {

	@Autowired
	private FinishedMaterialService finishedMaterialService;
	
	@PostMapping(value = "/save")
	public FinishedMaterial save(@RequestBody FinishedMaterial finishedMaterial)
	{
		return finishedMaterialService.save(finishedMaterial);
	}
	
	@GetMapping(value = "/get")
	public List<FinishedMaterial> get()
	{
		return finishedMaterialService.get();
	}
	
	@GetMapping(value = "/getById/{finishedMaterialId}")
	public Optional<FinishedMaterial> getyById(@PathVariable("finishedMaterialId") Long finishedMaterialId)
	{
		return finishedMaterialService.getyById(finishedMaterialId);
	}
	
	@DeleteMapping(value = "/delete/{finishedMaterialId}")
	public void delete(@PathVariable("finishedMaterialId") Long finishedMaterialId)
	{
		finishedMaterialService.delete(finishedMaterialId);
	}
}
