package com.authorization;

import com.authorization.configuration.boot.CreateDefaultUserListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class AuthorizationServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AuthorizationServerApplication.class, args);
		ctx.getBean(CreateDefaultUserListener.class);
	}
}
