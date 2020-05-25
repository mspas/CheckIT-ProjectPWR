package com.checkit.repository;

import java.util.List;

import com.checkit.entity.Lecture;
import com.checkit.entity.User;

public interface StudentReposiotryCustom {

	public List<Lecture> getStudentParticipatedLecturesForCourse(Long courseId, User student);
	
}
