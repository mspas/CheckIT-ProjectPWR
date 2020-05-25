package com.checkit.response.entity;

public class Logout {

	private Long id;
	private Boolean logged;

	public Logout(Long id, Boolean logged) {
		this.id = id;
		this.logged = logged;
	}

	public Logout() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isLogged() {
		return logged;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

}
