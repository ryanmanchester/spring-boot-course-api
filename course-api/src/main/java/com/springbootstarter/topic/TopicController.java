package com.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("1", "Spring Framework", "Spring Description"),
				new Topic("2", "Java Basics", "Java for beginners"),
				new Topic("3", "Selenium Advanced", "Advanced concepts for Selenium")
				
				);
	}

}
