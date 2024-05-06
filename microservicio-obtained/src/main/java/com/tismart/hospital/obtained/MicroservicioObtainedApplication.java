package com.tismart.hospital.obtained;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioObtainedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioObtainedApplication.class, args);
	}

}
