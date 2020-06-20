package com.test.myspringcloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MySpringCloudHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudHystrixDashboardApplication.class, args);
	}
}
