package com.tismart.hospital.registered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioRegisteredApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioRegisteredApplication.class, args);
	}

}
