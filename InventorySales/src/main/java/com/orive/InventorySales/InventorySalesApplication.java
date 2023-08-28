package com.orive.InventorySales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventorySalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySalesApplication.class, args);
	}

}
