package com.checkit.security;

import org.springframework.stereotype.Component;

import com.checkit.entity.token.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "checkit";

	public JwtUser validate(String token) {

		JwtUser jwtUser = null;

		try {

			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			jwtUser = new JwtUser();
			jwtUser.setEmail(body.getSubject());
			jwtUser.setId(Integer.parseInt((String) body.get("userId")));
			jwtUser.setName((String) body.get("name"));
			jwtUser.setRole((String) body.get("role"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jwtUser;

	}

}
