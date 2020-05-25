package com.checkit.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;
import com.checkit.response.entity.Student;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

	private EntityManager entityManager;

	public CourseRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Stream<User> getCourseParticipantsAsStream(Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession
				.createQuery("From User u where :course in elements(u.studentCourses) and u.role.name = :role");
		theQuery.setParameter("course", course);
		theQuery.setParameter("role", "STUDENT");
		return theQuery.stream();
	}

	@Override
	public List<Course> getCoursesByLecturerId(Long lecturerId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Course> theQuery = currentSession.createQuery(
				"Select u.lecturerCourses from User u " + "where u.id = :lecturerId and u.role.name = :role");
		theQuery.setParameter("lecturerId", lecturerId);
		theQuery.setParameter("role", "LECTURER");

		List<Course> courses = theQuery.getResultList();

		return courses;
	}

	@Override
	public int countCourseParticipants(Long courseId) {

		Session currentSession = entityManager.unwrap(Session.class);
		NativeQuery<BigInteger> theQuery = currentSession
				.createNativeQuery("SELECT count(*) from COURSE_STUDENT where STUDENT_COURSES.ID = :courseId");
		theQuery.setParameter("courseId", courseId);
		return theQuery.getSingleResult().intValue();

	}

	@Override
	public int getPresencesOnLectures(Long courseId, Long studentId) {
		Session currentSession = entityManager.unwrap(Session.class);
		NativeQuery<BigInteger> theQuery = currentSession.createNativeQuery(
				"SELECT COUNT(*) FROM student_lecture JOIN Lecture ON student_lecture.lecture_id = lecture.id"
						+ " WHERE student_lecture.user_id = :studentId and lecture.course_id = :courseId");
		theQuery.setParameter("courseId", courseId).setParameter("studentId", studentId);
		return theQuery.getSingleResult().intValue();

	}

	@Override
	public List<Lecture> getAllCourseLectures(Long courseId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Lecture> theQuery = currentSession.createQuery("Select c.lectures from Course c where c.id = :courseId");
		theQuery.setParameter("courseId", courseId);
		return theQuery.getResultList();
	}

	@Override
	public int countAllCourseLectures(Long courseId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Long> theQuery = currentSession
				.createQuery("SELECT count(elements(lectures)) from Course where id = :courseId");
		theQuery.setParameter("courseId", courseId);
		return theQuery.getSingleResult().intValue();
	}

	@Override
	public boolean isStudentSignedUp(Long courseId, Long studentId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession
				.createQuery("Select c.users from Course c where c.id = :courseId and c.users.id = :studentId");
		theQuery.setParameter("courseId", courseId);
		theQuery.setParameter("studentId", studentId);

		Optional<User> user = theQuery.uniqueResultOptional();

		if (user.isPresent()) {
			return true;
		}

		return false;
	}

}
