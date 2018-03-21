package com.cvs.PIM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.cvs.*"})
public class PIMApplication {

	public static void main(String[] args) {
		SpringApplication.run(PIMApplication.class, args);
	}
}
