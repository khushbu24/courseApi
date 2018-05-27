package com.dto;

import com.entity.Book_Publisher;

public class BookPublisherDTO {

    public Integer myBookId;
    public Integer myPublisherId;

    public Book_Publisher toEntity(){

        Book_Publisher b = new Book_Publisher();
        b.setBook_id(myBookId);
        b.setPublisher_id(myPublisherId);
        return b;
    }

    @Override
    public String toString() {
        return "BookPublisherDTO{" +
                "myBookId=" + myBookId +
                ", myPublisherId=" + myPublisherId +
                '}';
    }
}
