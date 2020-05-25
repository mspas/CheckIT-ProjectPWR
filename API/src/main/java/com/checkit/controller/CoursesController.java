package com.checkit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkit.customAnnotation.LecturerRoleAccess;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;
import com.checkit.repository.CourseRepository;
import com.checkit.response.entity.CourseDetails;
import com.checkit.response.entity.CourseSummary;
import com.checkit.service.CourseService;

@RestController

@RequestMapping(value = "/api/courses")
public class CoursesController {

	private CourseService courseService;

	public CoursesController(CourseService courseService) {
		this.courseService = courseService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{courseId}/details")
	@LecturerRoleAccess
	public CourseDetails getCourseDetails(@PathVariable Long courseId, @RequestHeader("X-Authorization") String token) {

		return courseService.getCourseDetails(courseId);

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{courseId}/summary")
	@LecturerRoleAccess
	public CourseSummary getCourseSummary(@PathVariable Long courseId, @RequestHeader("X-Authorization") String token) {

		return courseService.getCourseSummary(courseId);

	}

}
