package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "book_publisher")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Book_Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="book_id")
    public int bookId;

    @Column(name ="publisher_id")

    public int publisherId;

    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int book_id) {
        this.bookId = book_id;
    }

    public int getPublisher_id() {
        return publisherId;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisherId = publisher_id;
    }
}
