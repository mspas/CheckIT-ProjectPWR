package com.checkit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "lecturer_id", referencedColumnName = "id")
	private User lecturer;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "course_student")
	private List<User> users;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Lecture> lectures;

}
