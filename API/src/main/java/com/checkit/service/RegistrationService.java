package com.checkit.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.Account;
import com.checkit.entity.RegistrationEntity;
import com.checkit.entity.Role;
import com.checkit.entity.User;
import com.checkit.repository.AccountRepository;
import com.checkit.repository.RoleRepository;
import com.checkit.repository.UserRepository;

@Service
public class RegistrationService {

	private AccountService accountService;
	private UserRepository userRepository;
	private RoleService roleService;

	@Autowired
	public RegistrationService(AccountService accountService, UserRepository userRepository, RoleService roleService) {
		this.accountService = accountService;
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	@Transactional
	public void register(RegistrationEntity registrationEntity) {

		Account account = new Account(registrationEntity.getEmail(), registrationEntity.getPassword());

		Role role = roleService.getRole("STUDENT");
		User user = new User(registrationEntity.getName(), registrationEntity.getSurname(), account, role);
		userRepository.save(user);

	}

}
