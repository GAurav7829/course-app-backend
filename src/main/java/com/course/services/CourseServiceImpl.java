package com.course.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.CourseDao;
import com.course.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao dao;
	
	@Override
	public List<Course> getCourses() {
		return this.dao.findAll();
	}

	@Override
	public Course getCourse(Long id) {
		return this.dao.getOne(id);
	}

	@Override
	public Course addCourse(Course course) {
		Course save = this.dao.save(course);
		return save;
	}

	@Override
	public Course updateCourse(Course course) {
		Course save = this.dao.save(course);
		return save;
	}

	@Override
	public void deleteCourse(Long id) {
		Course course = this.dao.getOne(id);
		this.dao.delete(course);
	}

}
