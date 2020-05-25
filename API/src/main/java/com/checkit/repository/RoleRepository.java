package com.checkit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.checkit.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	public Role findByNameIgnoreCase(String name);

}
