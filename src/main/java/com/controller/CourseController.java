package com.controller;

import com.entity.Course;
import com.service.CourseService;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    @RequestMapping("/course/{courseIdKhushbu}")
    public Course getCourse(@PathVariable("courseIdKhushbu") String id) {
        return courseService.getCourse(id);


//        System.out.println(t.toString() + "topickhushbu" + t.getId());
//        return new ResponseEntity<Course>(t, HttpStatus.OK);

    }

    //Create new topic   /course
    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(course);

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

    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------


    //Get all Courses under Topic for Given Topic id
    @RequestMapping("/topics/{topicId}/courses")
    public Set<Course> getAllCoursesForATopic(@PathVariable String topicId) {
        return courseService.getAllCoursesForATopic(topicId);

    }

    //Get the Course under Topic for given TopicId and Course Id
    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    //@RequestMapping("/{topicId}/{courseId}")
    public Course getCourseForATopic(@PathVariable String topicId, @PathVariable String courseId) {
        return courseService.findByTopicAndCourse(courseId, topicId);


//        System.out.println(t.toString() + "topickhushbu" + t.getId());
//        return new ResponseEntity<Course>(t, HttpStatus.OK);

    }
    //Get the Course under Topic for given TopicId and Course Id
    @RequestMapping("getDetailsForGivenTopicIdAndCourseId")

    public Course getCourseForATopic2(@RequestParam("topicId") String topicId, @RequestParam("courseId") String courseId) {
        return courseService.findByTopicAndCourse(courseId, topicId);
    }


    //Create new course under Topic for given TopicId
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
    public void createCourse(@PathVariable String topicId,@RequestBody Course course) {
//        System.out.println("path variable topicId ->"+topicId);
//        System.out.println("Course variable course ->"+course);
        courseService.createCourseByTopicId(topicId,course);

    }

    //update the course under Topic Entity against Given TopivId and CourseId
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course")
    public void updateCourseByTopicId(@RequestBody Course course, @PathVariable String topicId) {
        courseService.updateCourseByTopicId(course,topicId);
    }
//
//    //update the topic   /course/id
////    @RequestMapping(method = RequestMethod.PUT,value = "/course/{id}")
////    public void updateCourseWithoutIdInRequestBody(@RequestBody Course course, @PathVariable String id){
////        courseService.updateCourseWithoutIdInRequestBody(course,id);
////    }
//
    //Delete course with TopicIDthe topic
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course")
    public ResponseEntity deleteCourseByTopicId(@RequestBody Course course, @PathVariable String topicId) {

        HttpStatus h= courseService.deleteCourse(course,topicId);
        return new ResponseEntity<>(null,h);
    }

}
