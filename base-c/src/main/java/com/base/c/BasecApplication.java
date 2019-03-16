package com.base.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BasecApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasecApplication.class, args);
    }
}
