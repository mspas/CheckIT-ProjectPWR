package com.checkit.repository;

import java.util.List;
import java.util.stream.Stream;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;

public interface CourseRepositoryCustom {
	
	public List<Course> getCoursesByLecturerId(Long lecturerId);
	
	public Stream<User> getCourseParticipantsAsStream(Course courseId);
	
	public int getPresencesOnLectures(Long courseId, Long studentId);
	
	public int countCourseParticipants(Long courseId);
	
	public List<Lecture> getAllCourseLectures(Long courseId);
	
	public int countAllCourseLectures(Long courseId);
	
	public boolean isStudentSignedUp(Long courseId, Long studentId);

}
