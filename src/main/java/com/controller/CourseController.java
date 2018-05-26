package com.controller;

import com.entity.Course;
import com.service.CourseService;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Get all Courses     /course
    @RequestMapping("/course")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    //Get the Course     /course/id
    @RequestMapping("/course/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);


//        System.out.println(t.toString() + "topickhushbu" + t.getId());
//        return new ResponseEntity<Course>(t, HttpStatus.OK);

    }

    //Create new topic   /course
    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public void createCourse(@RequestBody Course topic) {
        courseService.createCourse(topic);

    }

    //update the topic   /course/id
    @RequestMapping(method = RequestMethod.PUT, value = "/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable("id") String id) {
        courseService.updateCourse(course);
    }

    //update the topic   /course/id
//    @RequestMapping(method = RequestMethod.PUT,value = "/course/{id}")
//    public void updateCourseWithoutIdInRequestBody(@RequestBody Course course, @PathVariable String id){
//        courseService.updateCourseWithoutIdInRequestBody(course,id);
//    }

    //Delete the topic    /course/id
    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteCourseById(@RequestBody Course course, @PathVariable("id") String id) {

        courseService.deleteCourseById(id);
    }


}
