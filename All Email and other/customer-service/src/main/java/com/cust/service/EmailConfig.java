package com.cust.service;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfig {
	
	  @Bean
	   public JavaMailSender getJavaMailSender() {
	       JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
	       emailSender.setHost("smtp.gmail.com");
	       emailSender.setPort(587);

//	       emailSender.setUsername("avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com");
//	       emailSender.setPassword("Avanish8285696415");

	       Properties props = emailSender.getJavaMailProperties();
	       props.put("mail.transport.protocol", "smtp");
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.starttls.enable", "true");
	       props.put("mail.debug", "true");

	       return emailSender;
	   } 

}
//private String username="avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com";
////"avanishas123@outlook.com";
//private String password="Avanish8285696415";
