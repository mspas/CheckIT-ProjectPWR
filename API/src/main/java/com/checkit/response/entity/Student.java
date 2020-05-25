package com.checkit.response.entity;

public class Student {

	private String name;
	private String email;
	private Long indeks;
	private Long id;

	public Student(String name, String mail, Long indeks, Long id) {
		this.name = name;
		this.email = mail;
		this.indeks = indeks;
		this.id = id;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public long getIndeks() {
		return indeks;
	}

	public void setIndeks(Long indeks) {
		this.indeks = indeks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
