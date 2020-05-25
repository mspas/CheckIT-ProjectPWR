package com.checkit.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Role {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Getter
	private String name;

	@OneToMany(mappedBy = "role", cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST })
	@JsonIgnore
	private Collection<User> users;

	public boolean addUser(User user) {
		users.add(user);
		return true;
	}

}
