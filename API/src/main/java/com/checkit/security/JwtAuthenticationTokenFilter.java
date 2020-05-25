package com.checkit.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.checkit.entity.token.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationTokenFilter() {
		super("/hapi/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String header = request.getHeader("X-Authorization");

		if (header == null || !header.startsWith("Bearer ")) {

			throw new RuntimeException("JWT Token is missing");
		}

		String authenticationToken = header.substring(7);

		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

		return getAuthenticationManager().authenticate(token);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);

		chain.doFilter(request, response);

	}

}
