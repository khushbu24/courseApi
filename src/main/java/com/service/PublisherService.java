package com.service;

import com.entity.Publisher;
import com.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Set<Publisher> getAllPublishers() {

        List<Publisher> list=publisherRepository.findAll();
        Set<Publisher> set=new HashSet<>(list);
        return set;

    }

    public Publisher getPublisherById(int id) {
       return publisherRepository.getOne(id);
    }

    public void createPublisher(Publisher publisher) {
         publisherRepository.save(publisher);

    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Publisher publisher) {
        publisherRepository.deleteById(publisher.getId());
    }
}
