package com.checkit.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.checkit.entity.token.JwtAuthenticationToken;
import com.checkit.entity.token.JwtUser;
import com.checkit.entity.token.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;

		String token = jwtAuthenticationToken.getToken();

		JwtUser jwtuser = validator.validate(token);

		if (jwtuser == null) {
			throw new RuntimeException("JWT Token is incorrenct");

		}

		return new JwtUserDetails(jwtuser.getId(), jwtuser.getEmail(), token);

	}

	@Override
	public boolean supports(Class<?> aClass) {

		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}

}
