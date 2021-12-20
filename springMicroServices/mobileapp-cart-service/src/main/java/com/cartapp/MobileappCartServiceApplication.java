package com.cartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MobileappCartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileappCartServiceApplication.class, args);

    }

    @Bean
    @LoadBalanced
    // the restTemplate will choose the loadBalanced micoservice
    // based on the availability , fault tolerance and other factors
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
