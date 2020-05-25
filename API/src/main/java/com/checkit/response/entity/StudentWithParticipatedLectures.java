package com.checkit.response.entity;

import java.util.List;

public class StudentWithParticipatedLectures {

	private Student student;
	private List<Long> presences;

	public StudentWithParticipatedLectures(Student student, List<Long> presences) {
		this.student = student;
		this.presences = presences;
	}

	public StudentWithParticipatedLectures() {
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Long> getPresences() {
		return presences;
	}

	public void setPresences(List<Long> presences) {
		this.presences = presences;
	}

}
