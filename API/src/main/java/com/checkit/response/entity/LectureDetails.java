package com.checkit.response.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LectureDetails {

	private Long lectureId;
	private Date date;
	private String building;
	private String room;
	private String lecturer;
	private List<Student> students;

	public LectureDetails(Long lectureId, Date date, String building, String room, String lecturer,
			List<Student> students) {
		this.lectureId = lectureId;
		this.date = date;
		this.building = building;
		this.room = room;
		this.lecturer = lecturer;
		this.students = students;
	}

	public LectureDetails() {
	}

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}

	public String getDate() {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 'at' hh:mm:ss");
		return ft.format(this.date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
