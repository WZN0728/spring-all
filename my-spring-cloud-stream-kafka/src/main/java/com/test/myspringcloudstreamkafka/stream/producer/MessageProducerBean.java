/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.test.myspringcloudstreamkafka.owner.defined.OwnerDefinedSource;

/**
 * 消息生成者 Bean
 */
@Component
@EnableBinding({ Source.class, OwnerDefinedSource.class })
public class MessageProducerBean {

	@Autowired
	private Source source;

	@Autowired
	@Qualifier(Source.OUTPUT) // bean的名称
	private MessageChannel messageChannel;

	@Autowired
	private OwnerDefinedSource ownerDefinedSource;

	@Autowired
	@Qualifier(OwnerDefinedSource.OUTPUT) // bean的名称
	private MessageChannel ownerMessageChannel;

	public void send(String message) {
		// 通过消息管道发送消息
		// 1.messageChannel.send(MessageBuilder.withPayload(message).build());
		// 2.通过source发送
		// 3.通过KafkaTemplate发送
		// 1和2没有什么区别
		source.output().send(MessageBuilder.withPayload(message).build());
	}

	public void sendOwner(String message) {
		// 下面的两种方法也都是一样的，跟上边的send方法中的1和2方法都是一样的，只不过是自定义的方法
		// ownerMessageChannel.send(MessageBuilder.withPayload(message).build());
		ownerDefinedSource.ownerDefinedMessageChannel().send(MessageBuilder.withPayload(message).build());
	}

}
