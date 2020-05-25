package com.checkit.entity;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// testing lombok
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEntity {
	@Getter
	@NotNull
	private String email;
	@Getter
	@NotNull
	private String password;
	@Getter
	@NotNull
	private String name;
	@Getter
	@NotNull
	private String surname;

}
