package com.checkit.response.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

public class CourseDetails {

	private Long courseId;
	private String courseCode;
	private int lecturesAmount;
	private List<StudentWithPresencesAmout> students;

	public CourseDetails(Long courseId, String courseCode, int totalLectures, List<StudentWithPresencesAmout> students) {
		this.lecturesAmount = totalLectures;
		this.students = students;
		this.courseId = courseId;
		this.courseCode = courseCode;
	}

	public CourseDetails() {
	}

	public int getLecturesAmount() {
		return lecturesAmount;
	}

	public void setLecturesAmount(int totalLectures) {
		this.lecturesAmount = totalLectures;
	}

	public List<StudentWithPresencesAmout> getStudents() {
		return students;
	}

	public void setStudents(List<StudentWithPresencesAmout> students) {
		this.students = students;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
