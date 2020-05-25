package com.checkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.checkit.config.CorsFilter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class CheckItEbusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckItEbusinessApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration() {

		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CorsFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);

		return registrationBean;

	}

}
