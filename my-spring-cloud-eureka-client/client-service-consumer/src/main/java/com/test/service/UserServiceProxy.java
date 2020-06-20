/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.domain.service.UserService;
import com.test.domain.user.User;

/**
 * {@link UserService} proxy的实现
 */
@Service
public class UserServiceProxy implements UserService {

	private static final String PROVIDER_SERVER_URL_PREFIX = "http://client-service-provider";

	//通过rest api代理到服务器的提供者
	@Autowired
	private RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.domain.service.UserService#save(com.test.domain.user.User)
	 */
	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		User result = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
		return result != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.domain.service.UserService#findAll()
	 */
	@Override
	public Collection<User> findAll() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/findAll", Collection.class);
	}

}
