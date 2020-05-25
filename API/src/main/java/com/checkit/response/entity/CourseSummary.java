package com.checkit.response.entity;

import java.util.List;

public class CourseSummary {

	private Long courseId;
	private String courseCode;
	private List<StudentWithParticipatedLectures> students;
	private int lecturesAmount;

	public CourseSummary(Long courseId, String courseCode, List<StudentWithParticipatedLectures> students,
			int lecturesAmount) {
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.students = students;
		this.lecturesAmount = lecturesAmount;
	}

	public CourseSummary() {

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

	public List<StudentWithParticipatedLectures> getStudents() {
		return students;
	}

	public void setStudents(List<StudentWithParticipatedLectures> students) {
		this.students = students;
	}

	public int getLecturesAmount() {
		return lecturesAmount;
	}

	public void setLecturesAmount(int lecturesAmount) {
		this.lecturesAmount = lecturesAmount;
	}

}
