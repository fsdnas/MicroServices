package com.mobileapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//this is a microservice
//this means it is visible to other microservices
@EnableEurekaClient
public class MobileappMobServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MobileappMobServerApplication.class, args);
    }

}
