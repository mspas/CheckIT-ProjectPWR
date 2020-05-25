package com.checkit.repository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.checkit.entity.UserCredencials;
import com.checkit.entity.RegistrationEntity;
import com.checkit.entity.User;
import com.checkit.response.entity.LoginResponse;

public interface LoginRepository {

	public Optional<User> login(UserCredencials login);

}
