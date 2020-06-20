package com.test.myspringcloudzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
//@EnableZipkinServer HTTP收集的方式
@EnableZipkinStreamServer //Stream收集的方式
public class MySpringCloudZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudZipkinServerApplication.class, args);
	}
}
