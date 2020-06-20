/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceConsumerBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceConsumerBootstrap.class, args);
	}

	/**
	 * @LoadBalanced 负载均衡，这个注解将LoadBalancerInterceptor注入进来了，
	 * 然后通过LoadBalancerClient -> RibbonLoadBalancerClient 通过轮询IP的方式进行负载均衡
	 * （本机测试时只能通过端口号查看这种负载均衡的效果）
	 * 问题：
	 * 1.eureka通过随机数动态获取端口出现刷新延迟
	 * 2.eureka通过随机数动态获取端口会出现端口不一致的情况
	 * 3.通过netflix Ribbon的负载均衡出现数据查询不完全现象（由于本地测试开启三个本地服务）
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
