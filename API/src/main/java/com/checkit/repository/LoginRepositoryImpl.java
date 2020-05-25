package com.checkit.repository;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.checkit.entity.UserCredencials;
import com.checkit.entity.RegistrationEntity;
import com.checkit.entity.User;
import com.checkit.response.entity.LoginResponse;

import javassist.NotFoundException;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	private EntityManager entityManager;

	public LoginRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public Optional<User> login(UserCredencials userCredencials) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery(
				"Select u from User u where u.account.email = :email and u.account.password = :password", User.class);
		theQuery.setParameter("email", userCredencials.getEmail());
		theQuery.setParameter("password", userCredencials.getPassword());

		Optional<User> user = theQuery.uniqueResultOptional();
		return user;

	}

}
