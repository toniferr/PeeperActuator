package com.toni.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PeeperActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeeperActuatorApplication.class, args);
	}

}
