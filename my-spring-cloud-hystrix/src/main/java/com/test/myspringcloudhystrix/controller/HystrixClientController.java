/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudhystrix.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 
 */
@RestController
public class HystrixClientController {

	private static final Random random = new Random();
	
	@GetMapping("/hello/world2")
	public String getOtherThing() {
		return new HelloWorldCommand().execute();
	}
	
	private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String>{

		protected HelloWorldCommand() {
			super(HystrixCommandGroupKey.Factory.asKey("Hello World!!!"),100);
			// TODO Auto-generated constructor stub
		}

		/* (non-Javadoc)
		 * @see com.netflix.hystrix.HystrixCommand#run()
		 */
		@Override
		protected String run() throws Exception {
			// TODO Auto-generated method stub
			int value = random.nextInt(200);
			System.out.println("当前方法执行时间为："+value+"ms");
			Thread.sleep(100);
			return "Hello World!!!";
		}
		
		protected String getFallback() {
			return HystrixClientController.this.errorBackMethod();
		}
		
	}
	
	/**
	 * 当前方法{@link getSomeThing}如果执行正常则返回“Hello World!!!”，否则触发容错，返回“error back!!!”
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/hello/world1")
	@HystrixCommand(fallbackMethod = "errorBackMethod",
					commandProperties = {
							@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")}
					)
	public String getSomeThing() throws Exception {
		//如果时间大于100，则出发容错
		int value = random.nextInt(200);
		System.out.println("getSomeThing 方法执行时间为：" + value + "ms");
		Thread.sleep(value);
		return "Hello World!!!";
	}

	public String errorBackMethod() {
		return "error back!!!";
	}

}
