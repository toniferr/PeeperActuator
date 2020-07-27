package com.toni.actuator.actuators.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myHealthCheck")
public class CustomHealthIndicator implements HealthIndicator {
	
	@Override
	public Health health() {
		int errorCode = check(); // perform some specific health check
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

	public int check() {
		// Our logic to check health
		return 0;
	}
	/*
	 * @Override public Health health() {
	 * 
	 * Random random = new Random();
	 * 
	 * if(random.nextBoolean()){ return Health.down().withDetail("ERR-001",
	 * "Random failure").build(); }
	 * 
	 * return Health.up().build(); }
	 */
}