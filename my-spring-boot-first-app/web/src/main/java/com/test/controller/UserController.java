/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  UserController.java
 * @Package com.test.controller
 * @Copyright: 2018 All rights reserved.
 */
package com.test.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.User;
import com.test.repository.UserRepository;

/**
 * @ClassName: UserController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月15日 下午11:32:23
 */
@RestController
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/user/save")
	public User save(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		userRepository.save(user);
		return user;
	}

	@GetMapping("/user/findAll")
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

}
