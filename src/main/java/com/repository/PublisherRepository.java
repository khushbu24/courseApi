package com.repository;

import com.entity.Book;
import com.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
}
