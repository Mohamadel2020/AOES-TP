package com.ws.soap.webservices.soapcoursemanagement.soap;

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

//Enable Spring Web Services
@EnableWs

//Spring Configuration
@Configuration
public class WebserviceConfig {
	//MessageDispatcherServlet
		//ApplicationCOntext
	//url -> /ws/*
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	// /ws/courses.wsdl
		//PortType - CoursePort
		//Namespace = http://www.formation.uvs.edu.sn/Course
	//course-details.xsd
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultEsdl11Definition(XsdSchema coursesShema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://www.formation.uvs.edu.sn/Course");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesShema);
		return definition;
	}
	
	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
}
