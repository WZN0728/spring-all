/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringbootvalidation.controller;

import javax.validation.Valid;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.myspringbootvalidation.domain.User;

@RestController
public class UserController {
	
	@PostMapping("/user/save1")
	public User save1(@Valid User user) {
		return user;
	}
	
	@PostMapping("/user/save2")
	public User save2(@RequestBody User user) {
		//springframework的api的调用方式
		Assert.hasText(user.getName(), "用户名不能为空!");
		//JVM断言
		assert user.getId() <1001;
		return user;
	}

}
