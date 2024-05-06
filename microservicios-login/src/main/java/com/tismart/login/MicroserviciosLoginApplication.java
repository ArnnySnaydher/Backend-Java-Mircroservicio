package com.tismart.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviciosLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosLoginApplication.class, args);
	}

}
