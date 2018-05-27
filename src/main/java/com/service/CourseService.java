package com.service;

import com.entity.Course;
import com.entity.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.repository.CourseRepository;
import com.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;


    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getCourse(String id) {
        return (Course) courseRepository.getOne(id);
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourseWithoutIdInRequestBody(Course course, String id) {
        Course t = courseRepository.getOne(id);
        t.setName(course.getName());
        t.setDescription(course.getDescription());
        courseRepository.save(t);
    }

    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }

    public Set<Course> getAllCoursesForATopic(String topicId) {
        //return courseRepository.findByTopic3Id(topicId);
        Topic t=topicRepository.getOne(topicId);
       return t.getCourses();
    }

    public Course findByTopicAndCourse(String courseId, String topicId) {
        //return courseRepository.findByTopic3IdAndId(topicId, courseId);

        Topic t=topicRepository.getOne(topicId);
        Set<Course> courseSet=t.getCourses();
        for (Course c:courseSet){
            if (c.getId().equals(courseId)){
                return c;}

        }
        return null;
    }

    public void createCourseByTopicId(String topicId, Course course) {
        Topic t = topicRepository.getOne(topicId);
        course.setTopic3(t);
        courseRepository.save(course);

    }

    public void updateCourseByTopicId(Course course, String topicId) {
        Topic t = topicRepository.getOne(topicId);
        course.setTopic3(t);
        courseRepository.save(course);


    }

    public HttpStatus deleteCourse(Course course, String topicId) {
        try {
            Course c = courseRepository.getOne(course.getId());
            if (c.getTopic3().getId().equals(topicId)) {
                courseRepository.delete(c);
                return HttpStatus.OK;
            }
            else{
                return HttpStatus.CONFLICT;
            }
        } catch (Exception e) {

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }


    }
}
