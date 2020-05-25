package com.checkit.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

import lombok.Data;

@Entity
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "duration")
	private Integer duration;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "lecturer_id", referencedColumnName = "id")
	private User lecturer;

	@ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "student_lecture", joinColumns = { @JoinColumn(name = "lecture_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> students;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "lectureHall_id", referencedColumnName = "id")
	private LectureHall lectureHall;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "course_id")
	private Course course;

	public Lecture(Date date, User lecturer, LectureHall lectureHall, Course course, Integer duration) {
		this();
		this.date = date;
		this.duration = duration;
		this.lecturer = lecturer;
		this.lectureHall = lectureHall;
		this.course = course;
	}

	public Lecture() {
		students = new HashSet<User>();
	}

	public boolean addStudentToPresenceList(User user) {

		students.add(user);
		return true;

	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public User getLecturer() {
		return lecturer;
	}

	public void setLecturer(User lecturer) {
		this.lecturer = lecturer;
	}

	public Set<User> getStudents() {
		return students;
	}

	public void setStudents(Set<User> students) {
		this.students = students;
	}

	public LectureHall getLectureHall() {
		return lectureHall;
	}

	public void setLectureHall(LectureHall lectureHall) {
		this.lectureHall = lectureHall;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
