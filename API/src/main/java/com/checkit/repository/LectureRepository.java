package com.checkit.repository;

import org.springframework.data.repository.CrudRepository;

import com.checkit.entity.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Long>, LectureRepositoryCustom {

}
