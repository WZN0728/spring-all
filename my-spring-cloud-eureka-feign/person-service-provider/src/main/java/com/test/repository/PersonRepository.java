/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.entity.Person;

/**
 * {@link Person}仓储
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

}
