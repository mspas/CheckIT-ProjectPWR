package com.checkit.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.checkit.entity.Lecture;
import com.checkit.entity.User;

@Repository
public class StudentRepositoryImpl implements StudentReposiotryCustom {

	private EntityManager entityManager;

	public StudentRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Lecture> getStudentParticipatedLecturesForCourse(Long courseId, User student) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Lecture> theQuery = currentSession
				.createQuery("FROM Lecture l where :student in elements(l.students) and l.course.id = :courseId");
		theQuery.setParameter("student", student);
		theQuery.setParameter("courseId", courseId);

		return theQuery.getResultList();

	}

	//

}
