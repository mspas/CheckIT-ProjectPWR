package com.checkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.token.JwtUser;
import com.checkit.security.JwtGenerator;

@Service
public class TokenServiceImpl {

	private JwtGenerator jwtGenerator;

	@Autowired
	public TokenServiceImpl(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	public String generate(JwtUser jwtUser) {

		JwtGenerator jwtGenerator = new JwtGenerator();
		return jwtGenerator.generate(jwtUser);

	}

}
