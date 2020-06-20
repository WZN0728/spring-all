package com.test.myspringcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient//类似于@EnableEurekaClient，但是要比它更全面
public class MySpringCloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudZuulApplication.class, args);
	}
	
}
