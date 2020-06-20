/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  User.java
 * @Package com.test.domain
 * @Copyright: 2018 All rights reserved.
 */
package com.test.domain;

/**
 * @ClassName:  User
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年3月15日 下午11:32:39
 */
public class User {

	private long id;
	
	private String name;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
