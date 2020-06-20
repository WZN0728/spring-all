/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.myspringcloudstreamkafka.stream.producer.MessageProducerBean;

@RestController
public class MyProducerController {

	private final MessageProducerBean messageProducerBean;

	@Autowired
	public MyProducerController(MessageProducerBean messageProducerBean) {
		this.messageProducerBean = messageProducerBean;
	}

	/**
	 * 通过 {@link MessageProducerBean} 发送
	 * 
	 * @param message
	 * @return
	 */
	@GetMapping("/send/bean/msg")
	public boolean send(@RequestParam String message) {
		messageProducerBean.send(message);
		return true;
	}

	@GetMapping("/send/bean/owner")
	public boolean sendToOwner(@RequestParam String message) {
		messageProducerBean.sendOwner(message);
		return true;
	}

}
