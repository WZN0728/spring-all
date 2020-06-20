/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptorAdapter() {
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				super.postHandle(request, response, handler, modelAndView);
				log.info("request URI : {}", request.getRequestURI());
			}
		});
	}

}
