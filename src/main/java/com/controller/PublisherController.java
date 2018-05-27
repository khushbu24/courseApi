package com.controller;

import com.entity.Publisher;
import com.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    //Get all publishers
    @RequestMapping("/publishers")
    public Set<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    //get a publisher based in Id
    @RequestMapping("/publishers/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherService.getPublisherById(id);
    }

    //Create a publisher
    @RequestMapping(method = RequestMethod.POST, value = "/publishers")
    public void createPublisher(@RequestBody Publisher publisher) {
        publisherService.createPublisher(publisher);
    }

    //modify a publisher
    @RequestMapping(method = RequestMethod.PUT, value = "/publishers")
    public void updatePublisher(@RequestBody Publisher publisher) {
        publisherService.updatePublisher(publisher);
    }

    //Delete a publisher
    @RequestMapping(method = RequestMethod.DELETE, value = "/publishers")
    public void deletePublisher(@RequestBody Publisher publisher) {
        publisherService.deletePublisher(publisher);
    }


}
