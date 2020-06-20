/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.test.domain.user.User;

/**
 * {@link User}用户的仓储
 */
@Repository
public class UserRepository {

	private ConcurrentMap<Long, User> respository = new ConcurrentHashMap<Long, User>();

	public boolean save(User user) {
		return respository.putIfAbsent(user.getId(), user) == null;
	}

	public Collection<User> findAll() {
		return respository.values();
	}

}
