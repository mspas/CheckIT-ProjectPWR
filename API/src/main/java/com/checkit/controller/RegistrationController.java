package com.checkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkit.entity.RegistrationEntity;
import com.checkit.service.RegistrationService;

@Controller
@RequestMapping(value = "/")
public class RegistrationController {

	private RegistrationService registrationService;
	
	@Autowired
	public RegistrationController( RegistrationService registrationService) {
		this.registrationService = registrationService;

	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/registration")
	public ResponseEntity<Void> registration(@RequestBody RegistrationEntity registration) {

		registrationService.register(registration);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}
}
