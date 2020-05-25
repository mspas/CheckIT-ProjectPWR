package com.checkit.response.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.checkit.entity.Lecture;

public class LecturerCourses {

	private Long lecturerId;
	private List<Course> courses = new ArrayList<LecturerCourses.Course>();

	public LecturerCourses() {

	}

	public Course createCourseEntity(Long id, String name) {
		return new Course(id, name);
	}

	public boolean addToCourseList(Course course) {

		courses.add(course);
		return true;

	}

	public class Course {
		private Long id;
		private String name;
		private List<Lecture> lectures;

		public Course(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public void setLectures(List<com.checkit.entity.Lecture> lectureList) {

			List<Lecture> processedLectureList = new ArrayList<LecturerCourses.Lecture>();

			for (com.checkit.entity.Lecture lecture : lectureList) {

				LecturerCourses.Lecture processedLecture = new LecturerCourses.Lecture(lecture.getId(),
						lecture.getDate());
				processedLectureList.add(processedLecture);

			}
			this.lectures = processedLectureList;

		}

		public List<Lecture> getLectures() {
			return lectures;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

	}

	private class Lecture {

		private Long id;
		private Date date;

		public Lecture(Long id, Date date) {
			this.id = id;
			this.date = date;
		}

		public Long getId() {
			return id;
		}

		public String getDate() {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 'at' hh:mm:ss");
			return ft.format(this.date);
		}

	}

	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
