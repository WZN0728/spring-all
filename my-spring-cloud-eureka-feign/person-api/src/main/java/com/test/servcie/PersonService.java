/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.servcie;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.domain.Person;
import com.test.hystrix.PersonServiceFallBack;

@FeignClient(value = "person-service",fallback = PersonServiceFallBack.class) // 服务提供方的名称
public interface PersonService {

	/**
	 * 保存档当前对象{@link PersonService}
	 * 
	 * @param pseron
	 * @return 如果成功返回<code>true</code>,否则返回<code>false</code>
	 */
	@PostMapping(value = "/person/save")
	boolean save(@RequestBody Person pseron);

	/**
	 * @return 返回所有{@link PersonService}实例的集合
	 */
	@GetMapping(value = "/person/findAll")
	Collection<Person> findAll();

}
