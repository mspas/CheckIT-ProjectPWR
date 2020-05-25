package com.checkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkit.entity.UserCredencials;
import com.checkit.entity.RegistrationEntity;
import com.checkit.response.entity.LoginResponse;
import com.checkit.response.entity.Logout;
import com.checkit.service.LoginLogoutService;
import com.checkit.service.RegistrationService;

@RestController

@RequestMapping(value = "/")
public class LoginLogoutController {

	private LoginLogoutService loginLogoutService;

	@Autowired
	public LoginLogoutController(LoginLogoutService loginService) {
		this.loginLogoutService = loginService;

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponse> login(@RequestBody UserCredencials login) throws Exception, IllegalAccessException {

		LoginResponse loginResponse = loginLogoutService.login(login);
		try {
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		} catch (Exception e) {

			throw new Exception("wrong credencials");

		}

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/api/logout")
	public Boolean logout(@RequestBody Logout logoutEntity) {

		return loginLogoutService.Logout(logoutEntity.getId(), logoutEntity.isLogged());

	}
}
