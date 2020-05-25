package com.checkit.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.checkit.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u.logged FROM User u where u.id = :userId")
	public boolean isUserLogged(@Param("userId") Long userId);

	@Query("SELECT u FROM User u where u.account.email = :email")
	public User getUserByEmail(@Param("email") String email);

	@Modifying(clearAutomatically = true)
	@Query("Update User u set u.logged = :logged where u.id = :userId")
	public int updateLoggedStatus(@Param("userId") Long userId, @Param("logged") Boolean logged);

}
