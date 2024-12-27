package com.ukd.graphuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GraphUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphUserServiceApplication.class, args);
    }

}
