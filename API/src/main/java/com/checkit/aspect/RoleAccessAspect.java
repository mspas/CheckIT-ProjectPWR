package com.checkit.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResourceAccessException;
import com.checkit.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Aspect
@Configuration
public class RoleAccessAspect {

	private String secret = "checkit";

	@Autowired
	private UserRepository userRepository;

	@Pointcut("execution(* com.checkit.controller.*.*(..)) ")
	public void allControllers() {
	}

	@Before("allControllers() && args(..,token) && @annotation(com.checkit.customAnnotation.StudentRoleAccess) ")
	public void studentAccessMethods(String token) {

		if (!validateRole(token, "STUDENT")) {
			throw new ResourceAccessException("No resource access for that role");
		}

	}

	@Before("allControllers() && args(..,token) && @annotation(com.checkit.customAnnotation.LecturerRoleAccess)")
	public void lecturerAccessMethods(String token) {

		if (!validateRole(token, "LECTURER")) {
			throw new ResourceAccessException("No resource access for that role");
		}

	}

	private boolean validateRole(String token, String requiredRole) {
		Long id = getIdFromToken(token.substring(7));
		String userRole = userRepository.findById(id).get().getRole().getName();
		if (userRole.toUpperCase().equals(requiredRole)) {

			return true;
		}
		return false;
	}

	private Long getIdFromToken(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		Long id = (Long.parseLong((String) body.get("userId")));
		return id;
	}

}
