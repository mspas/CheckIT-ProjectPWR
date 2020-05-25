package com.checkit.entity;

public class PresenceEntity {

	private Long lectureId;
	private Long studentId;

	public PresenceEntity(Long lectureId, Long studentId) {
		this.lectureId = lectureId;
		this.studentId = studentId;
	}

	public PresenceEntity() {
	}

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}
