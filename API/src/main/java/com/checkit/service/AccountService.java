package com.checkit.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.Account;
import com.checkit.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public Optional<Account> getAccountById(String email) {

		return accountRepository.findById(email);

	}

	@Transactional
	public Account save(Account account) {
		return accountRepository.save(account);
	}

}
