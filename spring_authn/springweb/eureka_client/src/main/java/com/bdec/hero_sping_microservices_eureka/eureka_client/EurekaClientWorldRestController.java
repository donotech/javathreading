package com.bdec.hero_sping_microservices_eureka.eureka_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EurekaClientWorldRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate rest;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/world")
    public String world() {
        return "world";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        String hello = rest.getForObject("http://hello-service/hello", String.class);
        String world = rest.getForObject("http://world-service/world", String.class);

        return hello + " " + world;
    }
}
