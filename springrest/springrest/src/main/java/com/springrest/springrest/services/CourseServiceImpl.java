package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	//we make a list to temporary store the data
//	List<Course> list;
//	private Object courseservice;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl(){
		// in this we temporary add the courses using constructor
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Course", "this course contain basics of java"));
//		list.add(new Course(200, "Spring boot Course", "this course contain basics of Spring boot"));
//		list.add(new Course(300, "Microservices Course", "this course contain basics of Microservices"));
		
		
		
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course:list) 
//		{
//			if(course.getId()==courseId) 
//			{
//				c = course;
//				break;
//			}
//		}
//		return c;
		return courseDao.getOne(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId());{
//				e.setName(course.getName());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
		
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}
	
	
}