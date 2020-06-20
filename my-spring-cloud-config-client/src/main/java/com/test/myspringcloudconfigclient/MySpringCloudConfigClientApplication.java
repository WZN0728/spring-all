package com.test.myspringcloudconfigclient;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import com.test.myspringcloudconfigclient.health.MyHealthIndicator;

@SpringBootApplication
public class MySpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudConfigClientApplication.class, args);
	}
	
	private Environment environment;
	
	private ContextRefresher contextRefresher;

	public MySpringCloudConfigClientApplication(Environment environment, ContextRefresher contextRefresher) {
		this.environment = environment;
		this.contextRefresher = contextRefresher;
	}
	
	@Scheduled(fixedRate = 5 * 1000, initialDelay = 3 * 1000)
	public void autoRefresh() {
		Set<String> set = contextRefresher.refresh();
		set.forEach(propertyName -> System.err.printf("[Thread :%s] 当前配置已更新,具体的Key : %s, Value : %s \n", 
				Thread.currentThread().getName(),
				propertyName,
				environment.getProperty(propertyName)));
	}
	
	@Bean
	public MyHealthIndicator myHealthIndicator() {
		return new MyHealthIndicator();
	}
	
}
