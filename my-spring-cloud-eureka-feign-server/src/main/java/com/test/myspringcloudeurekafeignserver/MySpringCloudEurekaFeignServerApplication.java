package com.test.myspringcloudeurekafeignserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySpringCloudEurekaFeignServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudEurekaFeignServerApplication.class, args);
	}
}
