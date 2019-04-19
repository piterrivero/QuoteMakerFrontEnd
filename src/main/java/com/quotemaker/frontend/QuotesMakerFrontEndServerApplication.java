package com.quotemaker.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.quotemaker.frontend")
@EnableDiscoveryClient
public class QuotesMakerFrontEndServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesMakerFrontEndServerApplication.class, args);
	}
	
}
