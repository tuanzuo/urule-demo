package com.tz.urule.servlet;

import com.bstek.urule.KnowledgePackageReceiverServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;

@Component
public class KnowledgePackageReceiverServletRegistration {
	@Bean
	public ServletRegistrationBean<HttpServlet> registerURuleServlet(){
		return new ServletRegistrationBean<HttpServlet>(new KnowledgePackageReceiverServlet(),"/knowledgepackagereceiver");
	}
}
