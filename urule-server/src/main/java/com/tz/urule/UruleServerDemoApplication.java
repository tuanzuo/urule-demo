package com.tz.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("${rm.config}")
@ImportResource({"classpath:context.xml"})
public class UruleServerDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(UruleServerDemoApplication.class,args);
	}
}
