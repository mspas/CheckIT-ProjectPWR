package com.checkit.response.entity;

public class LoginResponse {

	private long id;
	private String name;
	private String role;
	private String token;
	private boolean logged;

	public LoginResponse(long id, String name, String role, String token, boolean logged) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.token = token;
		this.logged = logged;
	}

	public LoginResponse() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

}
