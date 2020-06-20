package com.test.myspringbootembeddedtomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.test.myspringbootembeddedtomcat.tomcat.TomcatConfiguration;

@SpringBootApplication
public class MySpringBootEmbeddedTomcatApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MySpringBootEmbeddedTomcatApplication.class, args);
		new SpringApplicationBuilder(args)
				.sources(MySpringBootEmbeddedTomcatApplication.class, TomcatConfiguration.class).run(args);
	}
}