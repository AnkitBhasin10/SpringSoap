package com.example.BatraSoap.web;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean msg(ApplicationContext context) {
		
		MessageDispatcherServlet msd = new MessageDispatcherServlet();
		
		msd.setApplicationContext(context);
		msd.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(msd,"/ws/*");
	}
	
	@Bean
	public XsdSchema courseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("CourseDetails.xsd"));
	}
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Def(XsdSchema courseSchema) {
		DefaultWsdl11Definition def = new DefaultWsdl11Definition();
		
		def.setPortTypeName("coursePort");
		def.setTargetNamespace("http://demosoap.com/courses");
		def.setLocationUri("/ws");
		def.setSchema(courseSchema);
		
		return def;
	}
}
