package com.tismart.hospital.updated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioUpdatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioUpdatedApplication.class, args);
	}

}
