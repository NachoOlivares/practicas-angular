package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.whiteam.model")
@SpringBootApplication(scanBasePackages = {"com.whiteam.service", "com.whiteam.controller", "com.whiteam.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Imprescindible para usar restTemplate
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
