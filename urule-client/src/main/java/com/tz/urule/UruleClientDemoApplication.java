package com.tz.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * urule客户端启动类
 */
@SpringBootApplication
@ImportResource({"classpath:urule/context.xml"})
public class UruleClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UruleClientDemoApplication.class,args);
	}
}
