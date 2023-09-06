package com.orive.Stock.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orive.Stock.Repository.StockRepository;

@Service
public class StockService {

	private Logger logger=LoggerFactory.getLogger(StockService.class);
	
    @Autowired
	private StockRepository stockRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    
    
}
