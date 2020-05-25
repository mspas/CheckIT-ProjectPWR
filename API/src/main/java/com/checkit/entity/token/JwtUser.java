package com.checkit.entity.token;

public class JwtUser {

	private long id;
	private String email;
	private String name;
	private String role;

	public JwtUser() {

	}

	public JwtUser(long id, String email, String name, String role) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", email=" + email + ", name=" + name + ", role=" + role + "]";
	}

	
	
}
