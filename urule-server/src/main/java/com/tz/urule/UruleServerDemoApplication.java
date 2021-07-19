package com.tz.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * urule服务端启动类
 */
@SpringBootApplication
@PropertySource("${rm.config}")
@ImportResource({"classpath:urule/context.xml"})
public class UruleServerDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(UruleServerDemoApplication.class,args);
	}
}
