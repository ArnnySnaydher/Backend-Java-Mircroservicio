package com.tismart.hospital.removed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioRemovedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioRemovedApplication.class, args);
	}

}
