package com.checkit.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.checkit.entity.Course;
import com.checkit.entity.Lecture;
import com.checkit.entity.User;

public interface LectureRepositoryCustom {

	public boolean addStudentToList(Lecture lecture);
	public Stream<User> getLectureParticipantsAsStream(Lecture lecture);
	public List<Lecture> getLecturerSchedule(Long lecturerId, Date startDate, Date destinationDate);
}
