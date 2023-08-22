package com.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	List<Topic> topics = Arrays.asList(
			new Topic("1", "Spring Framework", "Spring Description"),
			new Topic("2", "Java Basics", "Java for beginners"),
			new Topic("3", "Selenium Advanced", "Advanced concepts for Selenium")
			
			);
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id))
					   .findFirst().get();
	}
}
