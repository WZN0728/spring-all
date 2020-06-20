/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  Controller.java
 * @Package com.test.myspringbootembeddedtomcat.controller
 * @Copyright: 2018 All rights reserved.
 */
package com.test.myspringbootembeddedtomcat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:  Controller
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月2日 下午11:39:49
 */
@RestController
public class Controller {

	@GetMapping("/helloworld")
	public String getValue() {
		return "HelloWorld!!!";
	}
	
}
