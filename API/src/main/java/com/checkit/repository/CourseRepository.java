package com.checkit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.checkit.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>, CourseRepositoryCustom {

}
