/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.hystrix;

import java.util.Collection;
import java.util.Collections;

import com.test.domain.Person;
import com.test.servcie.PersonService;

/**
 * {@link PersonService}
 * hystrix熔断处理，如果接口执行失败，则跳转进当前的这个fallback中来进行处理
 */
public class PersonServiceFallBack implements PersonService{

	/* (non-Javadoc)
	 * @see com.test.servcie.PersonService#save(com.test.domain.Person)
	 */
	@Override
	public boolean save(Person pseron) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.test.servcie.PersonService#findAll()
	 */
	@Override
	public Collection<Person> findAll() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

}
