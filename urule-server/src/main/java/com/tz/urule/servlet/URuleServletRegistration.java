package com.tz.urule.servlet;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;

@Component
public class URuleServletRegistration {
	@Bean
	public ServletRegistrationBean<HttpServlet> registerURuleServlet(){
		return new ServletRegistrationBean<HttpServlet>(new URuleServlet(),"/urule/*");
	}
}
