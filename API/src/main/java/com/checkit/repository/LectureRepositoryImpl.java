package com.checkit.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;

public class LectureRepositoryImpl implements LectureRepositoryCustom {

	private EntityManager entityManager;

	public LectureRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	public boolean addStudentToList(Lecture lecture) {

		Session currentSession = entityManager.unwrap(Session.class);
		try {
			currentSession.saveOrUpdate(lecture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public Stream<User> getLectureParticipantsAsStream(Lecture lecture) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession
				.createQuery("From User u where :lecture in elements(u.sudentLectures) and u.role.name = :role");
		theQuery.setParameter("lecture", lecture);
		theQuery.setParameter("role", "STUDENT");
		return theQuery.stream();
	}

	@Override
	public List<Lecture> getLecturerSchedule(Long lecturerId, Date startDate, Date destinationDate) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Lecture> theQuery = currentSession.createQuery(
				"From Lecture l where l.lecturer.id = :lecturerId and l.date between :startDate and :destinationDate");
		theQuery.setParameter("startDate", startDate);
		theQuery.setParameter("destinationDate", destinationDate);
		theQuery.setParameter("lecturerId", lecturerId);

		return theQuery.getResultList();
	}

}
