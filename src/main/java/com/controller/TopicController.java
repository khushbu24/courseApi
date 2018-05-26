package com.controller;

import com.entity.Topic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class TopicController   {

    @Autowired
    private TopicService topicService;

    //Get all Topics     /topics
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    //Get the Topic     /topics/id
    @RequestMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable String id) {
        Topic t = topicService.getTopic(id);
        System.out.println(t.toString() + "topickhushbu" + t.getId());
        return new ResponseEntity<Topic>(t, HttpStatus.OK);

    }

    //Create new topic   /topics
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);

    }

    //update the topic   /topics/id
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
        topicService.updateTopic(topic);
    }

    //update the topic   /topics/id
//    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
//    public void updateTopicWithoutIdInRequestBody(@RequestBody Topic topic, @PathVariable String id){
//        topicService.updateTopicWithoutIdInRequestBody(topic,id);
//    }

    //Delete the topic    /topics/id
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopicById(@RequestBody Topic topic, @PathVariable("id") String id) {

        topicService.deleteTopicById(id);
    }


}
