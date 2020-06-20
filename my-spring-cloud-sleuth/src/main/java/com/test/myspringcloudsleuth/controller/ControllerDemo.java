/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudsleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerDemo {

	private final RestTemplate restTemplate;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	public ControllerDemo(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("")
	public String index() {
		String returnValue = "Hello,World!!!";
		log.info("{} index() : {}", getClass().getSimpleName(), returnValue);
		return returnValue;
	}

	/**
	 * 完整的调用链路
	 * spring-cloud-sleuth
	 * 	->spring-cloud-zuul
	 * 		->person-client
	 * 			->person-service
	 * @return
	 */
	@GetMapping("/to/zuul/person-client/person/findAll")
	public Object toZuul() {
		log.info("spring-cloud-sleuth#toZuul()***********************************");
		String url = "http://spring-cloud-zuul/person-client/person/findAll";
		return restTemplate.getForObject(url, Object.class);
	}

}
