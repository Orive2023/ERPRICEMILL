package com.orive.InventoryStock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.InventoryStock.Entity.Stock;
import com.orive.InventoryStock.Repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public Stock save(Stock stock)
	{
		return stockRepository.save(stock);
	}
	
	public List<Stock> get()
	{
		return stockRepository.findAll();
	}
	
	public Optional<Stock> getById(Long stockId)
	{
		return stockRepository.findById(stockId);
	}
	
	public void delete(Long stockId)
	{
		stockRepository.deleteById(stockId);
	}
}
