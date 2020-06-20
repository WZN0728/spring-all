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

import rx.Observer;
import rx.Scheduler;
import rx.Single;
import rx.schedulers.Schedulers;

/**
 * Reactivex Java Demo
 * 用Reactivex 实线与Hystrix相同的功能
 */
public class RxJavaDemo {

	public static void main(String[] args) {
		Random random = new Random();
		Single.just("Hello World").subscribeOn(Schedulers.immediate()).subscribe(
				new Observer() {

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("执行完成！！！");
					}

					@Override
					public void onError(Throwable arg0) {
						// TODO Auto-generated method stub
						System.out.println("熔断保护！");
					}

					@Override
					public void onNext(Object arg0) {
						// TODO Auto-generated method stub
						int value = random.nextInt(200);
						if(value > 100){
							throw new RuntimeException("容错！！！");
						}
						System.out.println("当前 方法执行时间为：" + value + "ms");
					}
				}
		);
	}
	
}
