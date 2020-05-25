package com.checkit.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.entity.PresenceEntity;
import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.LectureHall;
import com.checkit.entity.User;
import com.checkit.repository.LectureRepository;
import com.checkit.response.entity.CourseDetails;
import com.checkit.response.entity.LectureDetails;
import com.checkit.response.entity.Student;

@Service
public class LectureService {

	private LectureRepository lectureRepository;
	private StudentService studentService;

	@Autowired
	public LectureService(LectureRepository lectureRepository, StudentService studentService) {
		this.lectureRepository = lectureRepository;
		this.studentService = studentService;
	}

	@Transactional
	public boolean addStudentToLecture(PresenceEntity presenceEntity) {

		Lecture lecture = this.findLectureById(presenceEntity.getLectureId());
		User student = studentService.findStudentById(presenceEntity.getStudentId());

		// adds student to lecture list
		lecture.addStudentToPresenceList(student);
		// adds lecture to student lectures list
		student.markPresenceOnLecture(lecture);
		// updates adds relation between student and lecture in the database
		boolean updateStatus = lectureRepository.addStudentToList(lecture);
		return updateStatus;

	}

	@Transactional
	public LectureDetails getLectureDetails(Long lectureId) {

		Optional<Lecture> lectureOpt = lectureRepository.findById(lectureId);

		if (lectureOpt.isPresent()) {
			Lecture lecture = lectureOpt.get();
			// gets attendance list (List<Users>) from database and maps it to the list of Students
			List<Student> students = lectureRepository.getLectureParticipantsAsStream(lecture).map(u -> {

				Student student = new Student();
				student.setEmail(u.getAccount().getEmail());
				student.setIndeks(Long.parseLong(student.getEmail().substring(0, 6)));
				student.setName(u.getFirstName() + " " + u.getLastName());
				student.setId(u.getId());
				return student;

			}).collect(Collectors.toList());

			LectureHall lectureHall = lecture.getLectureHall();
			String lecturerName = lecture.getLecturer().getFirstName() + " " + lecture.getLecturer().getLastName();

			// Creates lectureDetails object and fills it with data
			LectureDetails lectureDetails = new LectureDetails();
			lectureDetails.setLectureId(lecture.getId());
			lectureDetails.setDate(lecture.getDate());
			lectureDetails.setBuilding(lectureHall.getBuilding());
			lectureDetails.setRoom(lectureHall.getRoom());
			lectureDetails.setLecturer(lecturerName);
			lectureDetails.setStudents(students);

			return lectureDetails;

		}
		return null;
	}

	@Transactional
	public Lecture findLectureById(Long lecureId) {

		Optional<Lecture> lecture = lectureRepository.findById(lecureId);

		if (lecture.isPresent()) {
			return lecture.get();
		}
		return null;
	}

}
