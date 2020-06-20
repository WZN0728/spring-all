/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TomcatConfiguration.java
 * @Package com.test.myspringbootembeddedtomcat.tomcat
 * @Copyright: 2018 All rights reserved.
 */
package com.test.myspringbootembeddedtomcat.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: TomcatConfiguration
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月2日 下午11:41:35
 */
@Configuration
public class TomcatConfiguration implements EmbeddedServletContainerCustomizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer#
	 * customize(org.springframework.boot.context.embedded.
	 * ConfigurableEmbeddedServletContainer)
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// System.out.println(container.getClass().getName());
		TomcatEmbeddedServletContainerFactory servletContainerFactory = (TomcatEmbeddedServletContainerFactory) container;
		servletContainerFactory.addContextCustomizers((context) -> {
			if (context instanceof StandardContext) {
				StandardContext standardContext = (StandardContext) context;
				// standardContext.setDefaultWebXml(defaultWebXml);// 设置默认的web.xml文件到 Context
				standardContext.setReloadable(true);
			}
		});
		servletContainerFactory.addConnectorCustomizers((connector) -> {
			/*Connector connector = new Connector();
			connector.setPort(9090);
			connector.setProtocol("HTTP/1.1");
			connector.setURIEncoding("UTF-8");*/
			//设置端口，此时tomcat中有两个端口，8080和9090
			connector.setPort(9090);
			connector.setURIEncoding("UTF-8");
			connector.setProtocol("HTTP/1.1");
		});
	}

}
