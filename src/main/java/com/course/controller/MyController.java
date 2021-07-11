package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Course;
import com.course.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService service;
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.service.getCourses();
	}
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return this.service.getCourse(Long.parseLong(id));
	}
//	@PostMapping(path="/courses",consumes = "application/json")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.service.addCourse(course);
	}
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.service.updateCourse(course);
	}
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id){
		try {
			this.service.deleteCourse(Long.parseLong(id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
