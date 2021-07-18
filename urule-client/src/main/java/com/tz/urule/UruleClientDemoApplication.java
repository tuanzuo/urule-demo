package com.tz.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:urule/context.xml"})
public class UruleClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UruleClientDemoApplication.class,args);
	}
}
