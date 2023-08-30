package com.orive.Mandi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class Mandi {

	public static void main(String[] args) {
		SpringApplication.run(Mandi.class, args);
	}

}
