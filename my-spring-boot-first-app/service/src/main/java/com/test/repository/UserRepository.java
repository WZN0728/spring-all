/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  UserRespository.java
 * @Package com.test.repository
 * @Copyright: 2018 All rights reserved.
 */
package com.test.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.User;

/**
 * @ClassName: UserRespository
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月15日 下午11:33:20
 */
@Repository
public class UserRepository {

	private final ConcurrentHashMap<Long, User> userRepository = new ConcurrentHashMap<Long, User>();

	private final AtomicLong userId = new AtomicLong();

	// userRepository.put(user.getId(), user) == null
	// 如果当前的user.getId()没有存储过，那么返回null,如果存储过那么就返回你之前存储的id，hashCode方法和equals方法将当前的id返回
	public boolean save(User user) {
		long id = userId.incrementAndGet();
		user.setId(id);
		return userRepository.put(id, user) == null;
	}

	public Collection<User> findAll() {
		return userRepository.values();
	}

}
