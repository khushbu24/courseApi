package com.service;

import com.entity.Topic;
import com.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }

    public Topic getTopic(String id) {
        return (Topic) topicRepository.getOne(id);
    }

    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopicWithoutIdInRequestBody(Topic topic,String id) {
        Topic t=topicRepository.getOne(id);
        t.setName(topic.getName());
        t.setDescription(topic.getDescription());
        topicRepository.save(t);
    }

    public void deleteTopicById(String id) {
        topicRepository.deleteById(id);
    }
}
