/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.rest.test.restonspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.test.restonspringmvc.domain.Person;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Person person;

	@GetMapping("/person/{id}")
	public Person getSomeThing(@PathVariable Integer id, @RequestParam(required = false) String name) {
		person.setId(id);
		person.setName(name);
		return person;
	}
	
	@PostMapping(value = "/person/json/to/properties",
            consumes = "text/plain",
            produces = "application/properties+person" // 响应类型
    )
    public Person personJsonToProperties(@RequestParam String json) {

        // JSON to Map
        // Map to Properties
        return null;
    }
	
	@PostMapping(value="/person/json/to/properties",
			produces="application/properties+person"//响应类型
			)
	public Person personJsonToProperties(@RequestBody Person person) {
		return person;
	}
	
	@PostMapping(value="/person/properties/to/json",
			consumes="application/properties+person",//请求类型 //content-type
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE//响应类型 //Accept
			)
	public Person personPropertiesToJson(@RequestBody Person person) {
		return person;
	}

}