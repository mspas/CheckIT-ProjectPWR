package com.checkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkit.customAnnotation.LecturerRoleAccess;
import com.checkit.entity.User;
import com.checkit.response.entity.LecturerCourses;
import com.checkit.response.entity.LecturerSchedule;
import com.checkit.service.LecturerService;

@RestController
@RequestMapping(path = "/api")
public class LecturerController {

	private LecturerService lecturerService;

	@Autowired
	public LecturerController(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/lecturers")
	public List<User> getAllLecturers() {
		return null;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/lecturers/{lecturerId}/courses")
	@LecturerRoleAccess
	public LecturerCourses getLecturerCourses(@PathVariable Long lecturerId, @RequestHeader("X-Authorization") String token) {

		return lecturerService.getLecturerCourses(lecturerId);

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/lecturers/{lecturerId}/schedule")
	@LecturerRoleAccess
	public LecturerSchedule getLecturerSchedule(@PathVariable Long lecturerId, @RequestHeader("X-Authorization") String token) {
		
		return lecturerService.getLecturerSchedule(lecturerId);
	}

}
