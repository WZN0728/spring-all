/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.stream.consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({ Sink.class })
public class MessageConsumerBean {

	@Autowired
	@Qualifier(Sink.INPUT)
	private SubscribableChannel subscribableChannel;

	// 通过 SubscribableChannel 订阅消息
	// 当字段注入完成后的回调
	@PostConstruct
	public void init() {
		// 实现异步回调
		subscribableChannel.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.println("subscribe : " + message.getPayload());
			}
		});
	}

	// 过 @ServiceActivator 订阅消息
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void onMessage(Object message) {
		System.out.println("@ServiceActivator : " + message);
	}

	// 通过 @StreamListener 订阅消息
	@StreamListener(Sink.INPUT)
	public void onMessage(String message) {
		System.out.println("@StreamListener : " + message);
	}

}
