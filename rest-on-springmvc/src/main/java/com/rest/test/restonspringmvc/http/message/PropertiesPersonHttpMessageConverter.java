/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.rest.test.restonspringmvc.http.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.rest.test.restonspringmvc.domain.Person;

public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

	public PropertiesPersonHttpMessageConverter() {
		super();
		setDefaultCharset(Charset.forName("UTF-8"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.AbstractHttpMessageConverter#supports(java
	 * .lang.Class)
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Person.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.AbstractHttpMessageConverter#readInternal(
	 * java.lang.Class, org.springframework.http.HttpInputMessage) 将请求内容中 Properties
	 * 内容转化成 Person 对象
	 */
	@Override
	protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		InputStream is = inputMessage.getBody();
		Properties properties = new Properties();
		properties.load(new InputStreamReader(is, getDefaultCharset()));
		Person person = new Person();
		person.setId(Integer.valueOf(properties.getProperty("person.id")));
		person.setName(properties.getProperty("person.name"));
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.AbstractHttpMessageConverter#writeInternal
	 * (java.lang.Object, org.springframework.http.HttpOutputMessage)
	 */
	@Override
	protected void writeInternal(Person t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		OutputStream os = outputMessage.getBody();
		Properties properties = new Properties();
		properties.setProperty("person.id", String.valueOf(t.getId()));
		properties.setProperty("person.name", t.getName());
		properties.store(new OutputStreamWriter(os, getDefaultCharset()), "written by server");
	}

}
