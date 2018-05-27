package com.service;

import com.entity.Book_Publisher;
import com.repository.BookPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPublisherService {

    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    public void createBookPublisher(Book_Publisher bp) {
        bookPublisherRepository.save(bp);
    }
}
