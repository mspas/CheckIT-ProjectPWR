package com.checkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkit.repository.LectureHallRepository;

@Service
public class LectureHallService {

	@Autowired
	private LectureHallRepository lectureHallRepository;

}
