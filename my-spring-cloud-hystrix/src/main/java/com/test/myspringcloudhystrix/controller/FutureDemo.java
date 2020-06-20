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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * FutureDemo
 */
public class FutureDemo {

	public static void main(String[] args) {
		Random random = new Random();
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<String> future = service.submit(() -> {
			int value = random.nextInt(200);
			System.out.println("当前 方法执行时间为：" + value + "ms");
			Thread.sleep(value);
			return "Hello world!!!";
		});
		try {
			String s = future.get(100, TimeUnit.MILLISECONDS);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("容错保护！！！");
		}
		service.shutdown();
	}

}
