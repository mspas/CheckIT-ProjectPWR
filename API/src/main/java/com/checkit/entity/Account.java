package com.checkit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private User user;

	public Account() {

	}

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
