package com.repository;

import com.entity.Course;
import com.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
    public Course findByDescription(String d);
    public Course findByName(String d);
   // public Course findByTopic(Topic t);


    public List<Course> findByTopic3Id(String topicId);
    public Course findByTopic3IdAndId(String topicId,String courseId);

}
