/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.personclient.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Person;
import com.test.servcie.PersonService;

/**
 * {@link PersonClientController} 实现 {@link PersonService}
 */
@RestController
public class PersonClientController implements PersonService {

	private PersonService personService;

	/**
	 * <p>
	 * Title: PersonClientController.java
	 * </p>
	 * <p>
	 * Description: 项目：person-client 包名：com.test.personclient.controller
	 * </p>
	 * <p>
	 * Copyright: Copyright (c) 2017
	 * </p>
	 * <p>
	 * Company: cyberplus
	 * </p>
	 * 
	 * @author wuting
	 * @date 2018年2月12日 上午10:21:08
	 * @version 1.0
	 */
	@Autowired
	public PersonClientController(PersonService personService) {
		this.personService = personService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.servcie.PersonService#save(com.test.servcie.PersonService)
	 */
	@Override
	public boolean save(@RequestBody Person pseron) {
		// TODO Auto-generated method stub
		return personService.save(pseron);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.servcie.PersonService#findAll()
	 */
	@Override
	public Collection<Person> findAll() {
		// TODO Auto-generated method stub
		return personService.findAll();
	}

}
