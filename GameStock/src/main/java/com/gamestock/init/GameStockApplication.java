package com.gamestock.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.gamestock.controller", "com.gamestock.dao", "com.gamestock.service"})
public class GameStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStockApplication.class, args);
	}

}
