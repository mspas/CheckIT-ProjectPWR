package com.checkit.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.customAnnotation.LecturerRoleAccess;
import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.repository.LectureRepository;
import com.checkit.repository.UserRepository;
import com.checkit.response.entity.LecturerCourses;
import com.checkit.response.entity.LecturerSchedule;

@Service
public class LecturerService {

	private UserRepository userRepository;
	private CourseServiceImpl courseService;
	private LectureRepository lectureRepository;

	@Autowired
	public LecturerService(UserRepository userRepository, CourseServiceImpl courseService,
			LectureRepository lectureRepository) {
		this.userRepository = userRepository;
		this.courseService = courseService;
		this.lectureRepository = lectureRepository;
	}

	public LecturerCourses getLecturerCourses(Long lecturerId) {

		// get lecturer courses form database
		List<Course> courses = courseService.getLecturerCourses(lecturerId);

		LecturerCourses lecturerCourses = new LecturerCourses();
		lecturerCourses.setLecturerId(lecturerId);
		// maps Courses from database for ready to send class
		for (Course course : courses) {

			LecturerCourses.Course processedCourse = lecturerCourses.createCourseEntity(course.getId(),
					course.getName());
			List<Lecture> lectures = new ArrayList<Lecture>();
			try {
				// get all lectures for particular course
				lectures = course.getLectures();
				// Error occurs when Lecturer has no lectures
			} catch (Exception e) {
				e.printStackTrace();
				// Occures when COURSE HAS NO LECTURES
			}

			processedCourse.setLectures(lectures);
			lecturerCourses.addToCourseList(processedCourse);

		}

		return lecturerCourses;

	}

	@LecturerRoleAccess
	public LecturerSchedule getLecturerSchedule(Long lecturerId) {

		// date formatters
		DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy:MM:dd", Locale.ENGLISH);
		// get today's date
		LocalDate now = LocalDate.now();

		String day = dtfDay.format(now).toUpperCase();
		int daysAfterWeekStart = 0;

		Days days = Days.valueOf(day);
		if (days == Days.MONDAY) {
			daysAfterWeekStart = 0;
		} else if (days == Days.TUESDAY) {
			daysAfterWeekStart = 1;
		} else if (days == Days.WEDNESDAY) {
			daysAfterWeekStart = 2;
		} else if (days == Days.THURSDAY) {
			daysAfterWeekStart = 3;
		} else if (days == Days.FRIDAY) {
			daysAfterWeekStart = 4;
		} else if (days == Days.SATURDAY) {
			daysAfterWeekStart = 5;
		} else if (days == Days.SUNDAY) {
			daysAfterWeekStart = 6;
		}
		// first day of week
		LocalDate startOfTheWeek = now.minusDays(daysAfterWeekStart);
		// last day of week
		LocalDate endOfTheWeek = now.plusDays(6);

		// Gets lecturer schedule
		List<Lecture> lectures = lectureRepository.getLecturerSchedule(lecturerId,
				java.sql.Date.valueOf(startOfTheWeek), java.sql.Date.valueOf(endOfTheWeek));
		// Creates lecturer schedule object to return
		LecturerSchedule schedule = new LecturerSchedule(lecturerId);
		schedule.addDailySchedule(lectures, java.sql.Date.valueOf(startOfTheWeek));

		return schedule;

	}

	enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

}
