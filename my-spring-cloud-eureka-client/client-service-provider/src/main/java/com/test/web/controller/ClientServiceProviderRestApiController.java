/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.service.UserService;
import com.test.domain.user.User;

/**
 * {@link UserServcie} 用户服务API提供方 REST API {@link RestController}
 */
@RestController
public class ClientServiceProviderRestApiController {

	@Autowired
	private UserService userService;

	/**
	 * @param name
	 *            请求参数为name的数据
	 * @return 如果保存成功的话就返回user对象 {@link User}
	 */
	@PostMapping("/user/save")
	public User save(@RequestBody User user) {
		if (userService.save(user)) {
			System.out.println("服务方保存user成功!!!" + user);
			return user;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return 如果请求成功的话就返回所有的user对象{@link User}
	 */
	@GetMapping("/user/findAll")
	public Collection<User> findAll() {
		return userService.findAll();
	}

}
