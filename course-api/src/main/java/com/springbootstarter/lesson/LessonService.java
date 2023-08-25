package com.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId)
						.forEach(lessons::add);
		return lessons;
	}
	
	
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public Optional<Lesson> getLesson(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id))
					   //.findFirst().get();
		return lessonRepository.findById(id);
	}

	public void updateLesson(String id, Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	public void deleteLesson(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		lessonRepository.deleteById(id);
	}
}
