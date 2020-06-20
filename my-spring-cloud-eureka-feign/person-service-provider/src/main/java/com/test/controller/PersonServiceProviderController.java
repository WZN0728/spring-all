/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.domain.Person;
import com.test.repository.PersonRepository;
import com.test.service.PersonService;

@RestController
public class PersonServiceProviderController {

	private static final Random random = new Random();

	private static final Map<Long, Object> person = new ConcurrentHashMap<Long, Object>();

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;

	@PostMapping(value = "/person/save")
	public boolean save(@RequestBody Person p) {
		// return person.put(p.getId(), p) == null; //这个是存储在内存中，每次重启项目都会丢失
		//这里为什么要用两个bean呢？因为有可能bean对象的职责是不一样的，就像有些bean是用来做持久化用，而有些bean只需要像上面的存在内存中
		com.test.entity.Person person = new com.test.entity.Person();
		BeanUtils.copyProperties(p, person);
		//下面的两种方式都是可以的，第一种比较死板，第二种比较灵活方便
		//personService.save(person);
		personRepository.save(person);
		return true;
	}
	
	@GetMapping("/person/list")
	public Page<com.test.entity.Person> querList(Pageable pageable){
		return personRepository.findAll(pageable);
	}

	@GetMapping(value = "/person/findAll")
	@HystrixCommand(fallbackMethod = "getErrorFallBackMethod", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") })
	public Collection<Object> findAll() throws Exception {
		int value = random.nextInt(200);
		System.out.println("findAll方法执行的时间：" + value + "ms");
		//改用数据库查询的方式
		List<Object> list = new ArrayList<Object>();
		Iterable<com.test.entity.Person> personIterable = personRepository.findAll();
		personIterable.forEach(person -> {
			list.add(person);
		});
		Thread.sleep(value);
		//return person.values();//这个是存储在内存中，每次重启项目都会丢失，所以会查询不到数据
		return list;
	}

	public Collection<Object> getErrorFallBackMethod() {
		System.err.println("发生熔断，在这里输出熔断信息!!!");
		return Collections.emptyList();
	}

}
