package com.checkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkit.customAnnotation.LecturerRoleAccess;
import com.checkit.entity.PresenceEntity;
import com.checkit.response.entity.LectureDetails;
import com.checkit.service.LectureService;

@RestController
@RequestMapping(value = "/api/lectures")
public class LectureController {

	@Autowired
	private LectureService lectureService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{lectureId}/details")
	@LecturerRoleAccess
	public LectureDetails getLectureDetails(@PathVariable Long lectureId) {

		return lectureService.getLectureDetails(lectureId);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/presence")
	public ResponseEntity<Boolean> addStudentTolecture(@RequestBody PresenceEntity presenceEntity) {

		ResponseEntity<Boolean> response;

		if (lectureService.addStudentToLecture(presenceEntity)) {

			response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
			return response;
		}

		response = new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		return response;

	}

}
