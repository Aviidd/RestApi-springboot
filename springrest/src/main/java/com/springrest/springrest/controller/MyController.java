package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	// initializing the variable 
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		// this is used for testing
		return "this is home page";
	}
	
	//get the course
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseservice.getCourses();
	}
	
	//get the single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	//from this we can add a course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	
	//from this we update the course
	@PutMapping("/couses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
	}
	
	//from this we delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId){
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
