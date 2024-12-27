package com.ukd.relationaluserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RelationalUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationalUserServiceApplication.class, args);
    }

}
