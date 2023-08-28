package com.orive.InventoryStock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryStockApplication.class, args);
	}

}
