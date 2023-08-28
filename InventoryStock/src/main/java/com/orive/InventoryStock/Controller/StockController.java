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

import com.orive.InventoryStock.Entity.Stock;
import com.orive.InventoryStock.Service.RawMaterialService;
import com.orive.InventoryStock.Service.StockService;
import com.orive.InventoryStock.Service.WasteMaterialService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@PostMapping(value = "/save")
	public Stock save(@RequestBody Stock stock)
	{
		return stockService.save(stock);
	}
	
	@GetMapping(value = "/get")
	public List<Stock> get()
	{
		return stockService.get();
	}
	
	@GetMapping("/getById/{stockId}")
	public Optional<Stock> getById(@PathVariable("stockId") Long stockId)
	{
		return stockService.getById(stockId);
	}
	
	@DeleteMapping(value = "/delete/{stockId}")
	public void delete(@PathVariable("stockId") Long stockId)
	{
		stockService.delete(stockId);
	}
}
