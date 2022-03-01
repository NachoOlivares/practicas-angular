package com.sudokuSolve.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//enable annotation for importing dao
@SpringBootApplication(scanBasePackages = {"com.sudokuSolve.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
