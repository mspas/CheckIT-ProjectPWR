package com.checkit.security;

import org.springframework.stereotype.Component;

import com.checkit.entity.token.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	private String secret = "checkit";

	public String generate(JwtUser jwtUser) {

		Claims claims = Jwts.claims() 
				.setSubject(jwtUser.getEmail());
		claims.put("userId", String.valueOf(jwtUser.getId()));
		claims.put("name", String.valueOf(jwtUser.getName()));
		claims.put("role", String.valueOf(jwtUser.getRole()));

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secret).compact();

	}

}
