package com.checkit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkit.customAnnotation.StudentRoleAccess;
import com.checkit.entity.User;
import com.checkit.response.entity.StudentCourses;
import com.checkit.service.StudentService;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

	private StudentService StudentService;

	public StudentController(StudentService studentService) {
		this.StudentService = studentService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/students")
	public Iterable<User> getAllStudents() {
		return StudentService.getAllStudents();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/students/{studentId}/courses")
	@StudentRoleAccess
	public StudentCourses getStudentCoursesWithDetails(@PathVariable Long studentId, @RequestHeader("X-Authorization") String token) {
		System.out.println("REQUEST /students/{studentId}/courses");
		return StudentService.getStudentCourses(studentId);

	}

}
