/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudstreamkafka.raw;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class MyKafkaProducer {

	//apache的简单api实现producer的消息发送
	public static void main(String[] args) throws Exception {
		//使用Properties创建初始化配置
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		//序列化JsonSerializer.class.getName()可以使用StringSerializer.class.getName()代替,类型问题
		//反序列化StringDeserializer
		properties.setProperty("key.serializer", JsonSerializer.class.getName());
		properties.setProperty("value.serializer", JsonSerializer.class.getName());
		//创建KafkaProducer，这个其实就是消息的生产者
		KafkaProducer kafaProducer = new KafkaProducer(properties);
		//参数构造
		String topic = "myTest";//主题
		Integer partition = 0;//分区的概念
		Long timestamp = System.currentTimeMillis();//消息的时间戳，这个参数其实就是first in--first out的一个控制
		String key = "message-key";
		String value = "wuting";//具体的消息
		//ProducerRecord是消息的载体，包含消息的所有信息，有些参数可以为空
		//ProducerRecord record = new ProducerRecord(topic, null, null, null, value);
		ProducerRecord record = new ProducerRecord(topic, partition, timestamp, key, value);
		Future<RecordMetadata> future = kafaProducer.send(record);
		RecordMetadata returnValue = future.get();
		System.err.println(returnValue.toString());
	}

}
