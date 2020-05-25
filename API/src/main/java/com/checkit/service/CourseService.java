package com.checkit.service;

import java.util.List;
import java.util.stream.Stream;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;
import com.checkit.response.entity.CourseDetails;
import com.checkit.response.entity.CourseSummary;
import com.checkit.response.entity.Student;

public interface CourseService {

	public List<Course> getLecturerCourses(Long lecturerId);

	
	public List<User> getCourseParticipants(Long courseId);
	
	public CourseDetails getCourseDetails(Long courseId);
	
	public CourseSummary getCourseSummary(Long courseId);
	
	public int countCourseParticipants(Long courseId);
	
	public List<Lecture> getAllCourseLectures(Long courseId);
	
	public int countAllCourseLectures(Long courseId);
	
	public boolean isStudentSignedUp(Long courseId, Long studentId);
	
	public int getPresencesOnLectures(Long courseId, Long studentId);
	
}
