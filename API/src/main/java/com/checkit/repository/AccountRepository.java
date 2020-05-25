package com.checkit.repository;

import org.springframework.data.repository.CrudRepository;

import com.checkit.entity.Account;

public interface AccountRepository extends CrudRepository<Account, String>{

}
