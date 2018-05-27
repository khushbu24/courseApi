package com.repository;

import com.entity.Book_Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPublisherRepository extends JpaRepository<Book_Publisher,Integer> {
}
