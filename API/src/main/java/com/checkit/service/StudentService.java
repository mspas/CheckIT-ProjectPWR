package com.checkit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.checkit.customAnnotation.StudentRoleAccess;
import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;
import com.checkit.repository.StudentRepositoryImpl;
import com.checkit.repository.UserRepository;
import com.checkit.response.entity.StudentCourses;

@Service
public class StudentService {

	private UserRepository userRepository;
	private StudentRepositoryImpl studentRepositoryImpl;
	private CourseServiceImpl courseService;

	public StudentService(UserRepository userRepository, CourseServiceImpl courseService,
			StudentRepositoryImpl studentRepositoryImpl) {
		this.userRepository = userRepository;
		this.courseService = courseService;
		this.studentRepositoryImpl = studentRepositoryImpl;
	}

	public Iterable<User> getAllStudents() {
		return userRepository.findAll();

	}

	public User findStudentById(Long studentId) {
		Optional<User> user = userRepository.findById(studentId);

		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}

	public StudentCourses getStudentCourses(Long studentId) {

		User student = this.findStudentById(studentId);
		StudentCourses studentCourses = new StudentCourses(student.getId());
		try {
			List<Course> courses = student.getStudentCourses(); // mam id kursu i nazwę

			for (Course course : courses) {
				System.out.println("COURSE NAME: " + course.getName());
				List<Lecture> lectures = studentRepositoryImpl.getStudentParticipatedLecturesForCourse(course.getId(),
						student);
				List<Date> presenceDates = new ArrayList<Date>();

				for (Lecture lecture : lectures) {
					System.out.println("LECTURE NAME: " + lecture.getId() + " " + lecture.getDate());
					presenceDates.add(lecture.getDate());
				}

				int presences = lectures.size();

				int lecturesAmount = courseService.countAllCourseLectures(course.getId());

				studentCourses.addCourse(course.getId(), course.getName(), course.getCode(), lecturesAmount, presences,
						presenceDates);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return studentCourses;

	}

}
