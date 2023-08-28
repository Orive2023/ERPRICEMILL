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

import com.orive.InventoryStock.Entity.WasteMaterial;
import com.orive.InventoryStock.Service.WasteMaterialService;

@RestController
@RequestMapping(value = "/wastematrial")
public class WasteMaterialController {

	@Autowired
	private WasteMaterialService wasteMaterialService;
	
	@PostMapping(value = "/save")
	public WasteMaterial save(@RequestBody WasteMaterial wasteMaterial)
	{
		return wasteMaterialService.save(wasteMaterial);
	}
	
	@GetMapping(value = "/get")
	public List<WasteMaterial> get()
	{
		return wasteMaterialService.get();
	}
	
	@GetMapping(value = "/getById/{wasteMaterialId}")
	public Optional<WasteMaterial> getById(@PathVariable("wasteMaterialId") Long wasteMaterialId)
	{
		return wasteMaterialService.getById(wasteMaterialId);
	}
	
	@DeleteMapping(value = "/delete/{wasteMaterialId}")
	public void delete(@PathVariable("wasteMaterialId") Long wasteMaterialId)
	{
		wasteMaterialService.delete(wasteMaterialId);
	}
}
