package com.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
					   .forEach(courses::add);
		return courses;
	}
	
	
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id))
					   //.findFirst().get();
		return courseRepository.findById(id);
	}

	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
