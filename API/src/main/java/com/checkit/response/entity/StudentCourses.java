package com.checkit.response.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentCourses {

	private Long studentId;
	private List<Course> courses = new ArrayList<>();

	public StudentCourses(Long studentId) {
		this.studentId = studentId;
	}

	public boolean addCourse(Long id, String name, String code, int lecturesAmount, int presences,
			List<Date> presenceDates) {

		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setCode(code);
		course.setLecturesAmmount(lecturesAmount);
		course.setPresence(presences);

		List<String> dates = new ArrayList<String>();

		for (Date date : presenceDates) {

			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			dates.add(ft.format(date));

		}

		course.setPresenceDates(dates);

		courses.add(course);
		return true;
	}

	private class Course {
		private Long id;
		private String name;
		private String code;
		private int presence;
		private int lecturesAmmount;
		@JsonProperty("dates")
		private List<String> presenceDates;

		public Course() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long courseId) {
			this.id = courseId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public int getPresence() {
			return presence;
		}

		public void setPresence(int presence) {
			this.presence = presence;
		}

		public int getLecturesAmmount() {
			return lecturesAmmount;
		}

		public void setLecturesAmmount(int lecturesAmmount) {
			this.lecturesAmmount = lecturesAmmount;
		}

		public List<String> getPresenceDates() {
			return presenceDates;
		}

		public void setPresenceDates(List<String> presenceDate) {
			this.presenceDates = presenceDate;
		}

	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
