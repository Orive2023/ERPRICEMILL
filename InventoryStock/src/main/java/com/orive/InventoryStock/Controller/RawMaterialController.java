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

import com.orive.InventoryStock.Entity.RawMaterial;
import com.orive.InventoryStock.Service.RawMaterialService;

@RestController
@RequestMapping(value = "/rawmaterial")
public class RawMaterialController {

	@Autowired
	private RawMaterialService rawMaterialService;
	
	@PostMapping(value = "/save")
	public RawMaterial save(@RequestBody RawMaterial rawMaterial)
	{
		return rawMaterialService.save(rawMaterial);
	}
	
	@GetMapping(value = "/get")
	public List<RawMaterial> get()
	{
		return rawMaterialService.get();
	}
	
	@GetMapping(value = "/getById/{rawMaterialId}")
	public Optional<RawMaterial> getById(@PathVariable("rawMaterialId") Long rawMaterialId)
	{
		return rawMaterialService.getById(rawMaterialId);
	}
	
	@DeleteMapping(value = "/delete/{rawMaterialId}")
	public void delete(@PathVariable("rawMaterialId") Long rawMaterialId)
	{
		rawMaterialService.delete(rawMaterialId);
	}

}
