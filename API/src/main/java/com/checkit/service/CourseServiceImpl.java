package com.checkit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;
import com.checkit.repository.CourseRepository;
import com.checkit.response.entity.CourseDetails;
import com.checkit.response.entity.CourseSummary;
import com.checkit.response.entity.Student;
import com.checkit.response.entity.StudentWithParticipatedLectures;
import com.checkit.response.entity.StudentWithPresencesAmout;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Transactional // tested
	@Override
	public List<Course> getLecturerCourses(Long lecturerId) {

		return courseRepository.getCoursesByLecturerId(lecturerId);
	}

	@Transactional
	@Override // tested
	public int getPresencesOnLectures(Long courseId, Long studentId) {
		int presences = courseRepository.getPresencesOnLectures(courseId, studentId);
		return presences;
	}

	@Transactional
	@Override
	public List<User> getCourseParticipants(Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);

		if (course.isPresent()) {
			List<User> students = courseRepository.getCourseParticipantsAsStream(course.get())
					.collect(Collectors.toList());
			return students;
		}

		return null;
	}

	@Transactional
	@Override
	public CourseDetails getCourseDetails(Long courseId) {

		Optional<Course> courseOpt = courseRepository.findById(courseId);

		if (courseOpt.isPresent()) {
			Course course = courseOpt.get();
			List<StudentWithPresencesAmout> students = courseRepository.getCourseParticipantsAsStream(course).map(u -> {

				String name = u.getFirstName() + " " + u.getLastName();
				String mail = u.getAccount().getEmail();
				Long indeks = Long.parseLong(mail.substring(0, 6));
				Long id = u.getId();
				int presences = courseRepository.getPresencesOnLectures(course.getId(), u.getId());

				StudentWithPresencesAmout student = new StudentWithPresencesAmout(name, mail, indeks, id, presences);

				return student;

			}).collect(Collectors.toList());

			int lecturesAmmount = courseRepository.countAllCourseLectures(course.getId());

			CourseDetails courseDetails = new CourseDetails(course.getId(), course.getCode(), lecturesAmmount,
					students);

			return courseDetails;

		}

		return null;
	}

	@Override
	public CourseSummary getCourseSummary(Long courseId) {

		Optional<Course> courseOpt = courseRepository.findById(courseId);

		if (courseOpt.isPresent()) {
			Course course = courseOpt.get();
			// list of students containing students informations and list with numbers of
			// participated lectures
			List<StudentWithParticipatedLectures> students = courseRepository.getCourseParticipantsAsStream(course)
					.map(u -> {

						List<Lecture> studentLectures = new ArrayList<Lecture>(u.getSudentLectures());
						// list with numbers of participated lectures
						List<Long> participatedLectures = new ArrayList<Long>();

						List<Lecture> allLectures = course.getLectures();
						// sorts list of student lectures by date
						allLectures.sort((c1, c2) -> {
							return c1.getDate().compareTo(c2.getDate());
						});

						// finds numbers of participated lectures. 1st lecture responds to number 1, 3rd
						// responds to number 3
						for (int i = 0; i < allLectures.size(); i++) {

							if (studentLectures.contains(allLectures.get(i))) {
								participatedLectures.add(i + 1L);
							}
						}

						String name = u.getFirstName() + " " + u.getLastName();
						String mail = u.getAccount().getEmail();
						Long indeks = Long.parseLong(mail.substring(0, 6));
						Long id = u.getId();
						
						// Maps User into student and adds participated lectures list
						StudentWithParticipatedLectures student = new StudentWithParticipatedLectures(
								new Student(name, mail, indeks, id), participatedLectures);

						return student;

					}).collect(Collectors.toList());

			int lecturesAmmount = courseRepository.countAllCourseLectures(course.getId());

			// Creates course summary - course id, course code, students list and total
			// number of lectures
			CourseSummary courseSummary = new CourseSummary(course.getId(), course.getCode(), students,
					lecturesAmmount);

			return courseSummary;

		}
		
		return null;

	}

	@Transactional
	@Override
	public int countCourseParticipants(Long courseId) {

		return courseRepository.countCourseParticipants(courseId);

	}

	@Transactional
	@Override
	public List<Lecture> getAllCourseLectures(Long courseId) {

		return courseRepository.getAllCourseLectures(courseId);

	}

	@Transactional
	@Override
	public int countAllCourseLectures(Long courseId) {

		return courseRepository.countAllCourseLectures(courseId);
	}

	@Transactional
	@Override
	public boolean isStudentSignedUp(Long courseId, Long studentId) {

		return courseRepository.isStudentSignedUp(courseId, studentId);
	}

}
