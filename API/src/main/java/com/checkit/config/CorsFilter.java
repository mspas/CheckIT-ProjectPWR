package com.checkit.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class CorsFilter extends GenericFilterBean implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow--Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "86400 ");

		chain.doFilter(servletRequest, servletResponse);

	}

}


