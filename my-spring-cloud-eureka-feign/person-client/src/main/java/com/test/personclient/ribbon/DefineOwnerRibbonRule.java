/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test.personclient.ribbon;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class DefineOwnerRibbonRule extends AbstractLoadBalancerRule{

	/* (non-Javadoc)
	 * @see com.netflix.loadbalancer.IRule#choose(java.lang.Object)
	 */
	//永远获取第一台服务器
	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		ILoadBalancer iLoadBalancer = getLoadBalancer();
		List<Server> allServers = iLoadBalancer.getAllServers();
		return allServers.get(0);
	}

	/* (non-Javadoc)
	 * @see com.netflix.client.IClientConfigAware#initWithNiwsConfig(com.netflix.client.config.IClientConfig)
	 */
	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
