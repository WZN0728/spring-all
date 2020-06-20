/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.owner.defined;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OwnerDefinedSource {

	String OUTPUT = "ownerDefinedMessageChannel";
	
	@Output(OUTPUT)
	MessageChannel ownerDefinedMessageChannel();
	
}
