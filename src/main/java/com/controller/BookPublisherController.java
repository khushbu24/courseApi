package com.controller;

import com.dto.BookPublisherDTO;
import com.entity.Book_Publisher;
import com.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookPublisherController {

    @Autowired
    private BookPublisherService bookPublisherService;

    // create book publisher Map
    @RequestMapping(method = RequestMethod.POST, value = "/bookPublishers")
    public void createBookPublisher(@RequestBody BookPublisherDTO bpDto){
        System.out.println(bpDto.toString() + "khushbu123");
        Book_Publisher bp = bpDto.toEntity();

        bookPublisherService.createBookPublisher(bp);


    }
}
