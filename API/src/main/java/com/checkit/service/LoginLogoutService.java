package com.checkit.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.UserCredencials;
import com.checkit.entity.User;
import com.checkit.entity.token.JwtUser;
import com.checkit.repository.LoginRepository;
import com.checkit.repository.UserRepository;
import com.checkit.response.entity.LoginResponse;

@Service
public class LoginLogoutService {

	// private LoginRepository loginRepository;
	private UserRepository userRepository;
	private AuthorizationServiceImpl authorizationService;
	private TokenServiceImpl tokenService;

	@Autowired
	public LoginLogoutService(UserRepository userRepository, AuthorizationServiceImpl authorizationService,
			TokenServiceImpl tokenService) {
		this.userRepository = userRepository;
		this.authorizationService = authorizationService;
		this.tokenService = tokenService;
	}

	@Transactional
	public LoginResponse login(UserCredencials login) throws Exception, IllegalAccessException {
		// Validates provided user credentials (login and password). If validated,
		// returns jwtUser object with Id, email, name, role of the user otherwise
		// return null
		JwtUser jwtUser = authorizationService.authorize(login);

		// if request passed validation
		if (jwtUser != null) {

			Optional<User> userOpt = userRepository.findById(jwtUser.getId());
			String name = jwtUser.getName();
			String role = jwtUser.getRole();
			Boolean logged = userOpt.get().getLogged();

			// generates token from jwtUser fields
			String token = tokenService.generate(jwtUser);

			if (!logged) {
				LoginResponse response = new LoginResponse(jwtUser.getId(), name, role, token, logged);
				// updates logged status to true - user logged
				userRepository.updateLoggedStatus(jwtUser.getId(), true);
				return response;
			} else {
				// occurs when user is already logged on different device. In the response all
				// fields are set to null except logged status which is set to true
				LoginResponse response = new LoginResponse();
				response.setLogged(logged);
				return response;
			}

		} else {
			throw new Exception("wrong credencials");

		}

	}

	@Transactional
	public Boolean Logout(Long userId, Boolean logged) {

		userRepository.updateLoggedStatus(userId, logged);
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			return user.get().getLogged();

		} else {
			return false;
		}

	}

}
