package com.course.services;

import java.util.List;

import com.course.entity.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(Long id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(Long id);
}
