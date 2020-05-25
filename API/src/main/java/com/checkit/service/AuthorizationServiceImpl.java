package com.checkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.checkit.entity.Account;
import com.checkit.entity.UserCredencials;
import com.checkit.entity.User;
import com.checkit.entity.token.JwtUser;

@Service
public class AuthorizationServiceImpl {

	private UserService userService;
	private BCryptPasswordEncoder BCEncoder;

	@Autowired
	public AuthorizationServiceImpl(UserService userService, BCryptPasswordEncoder BCEncoder) {

		this.userService = userService;
		this.BCEncoder = BCEncoder;
	}

	public JwtUser authorize(UserCredencials userCredentials) {

		String email = userCredentials.getEmail();
		String rawPassword = userCredentials.getPassword();
		try {
			User theUser = userService.getUserByEmail(email);
			String dbEncryptedPassword = theUser.getAccount().getPassword();

			// matches hashed password from database with delivered by user and hashed password.
			boolean isPasswordCorrect = BCEncoder.matches(rawPassword, dbEncryptedPassword);

			if (isPasswordCorrect) {

				String name = theUser.getFirstName() + " " + theUser.getLastName();
				String role = theUser.getRole().getName();

				JwtUser jwtUser = new JwtUser(theUser.getId(), theUser.getAccount().getEmail(), name, role);

				return jwtUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
