package com.checkit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.User;
import com.checkit.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	public User getUserByEmail(String email) {

		return userRepository.getUserByEmail(email);

	}

//	public boolean updateUserLoggedFlag(Long userId, Boolean loggedFlag) {
//		
//		Optional<User> userOpt = userRepository.findById(userId);
//		
//		if(userOpt.isPresent()) {
//			User user = userOpt.get();
//			user.setLogged(loggedFlag);
//			user = userRepository.save(user);
//			return user.getLogged();
//		}

//	}
}
