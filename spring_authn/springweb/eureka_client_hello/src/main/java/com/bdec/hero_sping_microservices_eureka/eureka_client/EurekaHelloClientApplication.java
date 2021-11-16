package com.bdec.hero_sping_microservices_eureka.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaHelloClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHelloClientApplication.class, args);
	}

}
