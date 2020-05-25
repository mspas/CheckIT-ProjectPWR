package com.checkit.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.checkit.entity.Role;
import com.checkit.repository.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Transactional
	public Role getRole(String roleName) {

		return roleRepository.findByNameIgnoreCase(roleName);

	}

//	public Role getUserRole(Long userId) {
//		
//		return roleRepository.findByNameIgnoreCase(roleName);
//		
//	}

}
