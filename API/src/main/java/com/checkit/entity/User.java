package com.checkit.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class User {

	public User(String firstName, String lastName, Account account, Role role) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.setAccount(account);
		this.setRole(role);
	}

	public User() {
		sudentLectures = new HashSet<Lecture>();
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long id;
	@Setter
	private String firstName;
	@Setter
	private String lastName;
	@Column(name = "logged")
	private Boolean logged;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore()
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Account account;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JsonIgnore
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Role role;

	@OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST })
	@JsonIgnore
	private List<Lecture> lecturerLectures;

	@ManyToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST })
	@JsonIgnore
	private Set<Lecture> sudentLectures;

	@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST })
	@JsonIgnore
	private List<Course> studentCourses;

	@OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST })
	private List<Course> lecturerCourses;

	public boolean setRole(Role role) {

		this.role = role;
		role.addUser(this);
		return true;

	}

	public boolean setAccount(Account account) {

		this.account = account;
		account.setUser(this);
		return true;

	}

	public boolean markPresenceOnLecture(Lecture lecture) {
		sudentLectures.add(lecture);
		return true;

	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

}
