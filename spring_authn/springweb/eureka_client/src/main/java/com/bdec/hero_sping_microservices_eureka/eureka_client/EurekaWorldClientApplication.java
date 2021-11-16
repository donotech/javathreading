package com.bdec.hero_sping_microservices_eureka.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaWorldClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaWorldClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplateBean(){

		return new RestTemplate();

	}
}
