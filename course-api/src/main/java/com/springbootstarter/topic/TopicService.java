package com.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Spring Framework", "Spring Description"),
			new Topic("2", "Java Basics", "Java for beginners"),
			new Topic("3", "Selenium Advanced", "Advanced concepts for Selenium")
			
			));
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id))
					   .findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}
		
	}

	public Topic deleteTopic(String id) {
		Topic deletedTopic = null;
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				deletedTopic = topics.remove(i);
			}
		}
		return deletedTopic;
	}
}
