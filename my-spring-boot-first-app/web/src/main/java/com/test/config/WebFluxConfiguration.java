/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  WebFluxConfiguration.java
 * @Package com.test.config
 * @Copyright: 2018 All rights reserved.
 */
package com.test.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.test.domain.User;
import com.test.repository.UserRepository;

import reactor.core.publisher.Flux;

/**
 * @ClassName: WebFluxConfiguration
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月15日 下午11:47:03
 */
@Configuration
public class WebFluxConfiguration {

	/**
	 * webFlux的请求方式，可以通过当前的两个方法直接访问到/user/findAll，也就是路由RouterFunction
	 * @Title: queryAllUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param userRepository
	 * @param: @return
	 * @return: RouterFunction<ServerResponse>
	 * @throws
	 */
	@Bean
	@Autowired
	public RouterFunction<ServerResponse> queryAllUser(UserRepository userRepository) {
		Collection<User> users = userRepository.findAll();
		Flux<User> userFlux = Flux.fromIterable(users);
		return RouterFunctions.route(RequestPredicates.path("/queryAllUser"),
				request -> ServerResponse.ok().body(userFlux, User.class));
	}

	@Bean
	@Autowired
	public RouterFunction<ServerResponse> findAllUser(UserRepository userRepository) {
		Collection<User> users = userRepository.findAll();
		Flux<User> userFlux = Flux.fromIterable(users);
		return RouterFunctions.route(RequestPredicates.path("/findAllUser"),
				request -> ServerResponse.ok().body(userFlux, User.class));
	}

}
