/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.myspringcloudconfigclient.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

public class MyHealthIndicator extends AbstractHealthIndicator{

	/* (non-Javadoc)
	 * @see org.springframework.boot.actuate.health.AbstractHealthIndicator#doHealthCheck(org.springframework.boot.actuate.health.Health.Builder)
	 */
	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		// TODO Auto-generated method stub
		//builder.up().withDetail("MyHealthIndicator", "Up");
		builder.down().withDetail("MyHealthIndicator","Down");
	}

}
