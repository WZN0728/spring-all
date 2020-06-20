/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.service.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.service.UserService;
import com.test.domain.user.User;
import com.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.test.domain.service.UserService#save(com.test.domain.user.User)
	 */
	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.test.domain.service.UserService#findAll()
	 */
	@Override
	public Collection<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
