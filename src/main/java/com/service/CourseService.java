package com.service;

import com.entity.Course;
import com.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return (List<Course>)courseRepository.findAll();
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

    public void updateCourseWithoutIdInRequestBody(Course course,String id) {
        Course t=courseRepository.getOne(id);
        t.setName(course.getName());
        t.setDescription(course.getDescription());
        courseRepository.save(t);
    }

    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }
}
