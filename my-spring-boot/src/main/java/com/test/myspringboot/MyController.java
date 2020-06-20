/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private Animal animal;
	
	@RequestMapping("/getValue")
	public String getSomeThing(@RequestParam("name") String name) {
		return name;
	}

	/**
	 * @param request
	 * @param response
	 * @param age
	 * @return
	 * 在没有defaultValue的配置情况下，required=true时前台不传值就会报错
	 * 如果有efaultValue的配置情况下，required=true是失效的（配置或者不配置不影响最终的执行结果）
	 */
	@RequestMapping("/getValue2")
	public Integer getSomeAnthorThing(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "age", defaultValue = "18", required = false) Integer age) {
		System.out.println("**************************************");
		System.out.println(animal.getType());
		System.out.println(animal.getName());
		System.out.println("**************************************");
		return age;
	}

}