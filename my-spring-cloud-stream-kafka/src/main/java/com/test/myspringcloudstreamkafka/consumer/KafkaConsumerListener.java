/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

	@KafkaListener(topics = "${kafka.topic}")
	public void onMessage(String message) {
		System.err.println("消费者监听器接收到的内容：" + message);
	}
	
	@KafkaListener(topics = "myTest")
	public void onOwnerMessage(String message) {
		System.err.println("消费者监听器接收到的内容：" + message);
	}

}
