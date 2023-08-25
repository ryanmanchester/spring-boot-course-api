package com.springbootstarter.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstarter.course.Course;
import com.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id) {
		return lessonService.getAllLessons(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Optional<Lesson> getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "",""));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateTopic(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) {
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.updateLesson(id, lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}

}
