package com.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
