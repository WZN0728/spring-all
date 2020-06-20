package com.test.myspringcloudhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableCircuitBreaker
@EnableTurbine
public class MySpringCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudHystrixApplication.class, args);
	}
}
