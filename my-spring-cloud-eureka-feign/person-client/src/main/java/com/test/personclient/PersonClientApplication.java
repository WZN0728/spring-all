/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.personclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.test.servcie.PersonService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
//@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
@EnableHystrix
//@Import(WebConfig.class)
public class PersonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonClientApplication.class, args);
	}

	/*@Bean
	public DefineOwnerRibbonRule defineOwnerRibbonRule() {
		return new DefineOwnerRibbonRule();
	}*/

}
