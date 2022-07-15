package com.assignment.udemy.controller;

import com.assignment.udemy.entity.Course;
import com.assignment.udemy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @CrossOrigin
    @PostMapping
    private Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @CrossOrigin
    @PostMapping("/list")
    private List<Course> addListCourses(@RequestBody List<Course> courses){
        return courseService.addListCourses(courses);
    }

    @CrossOrigin
    @GetMapping
    private List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private void deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
    }

    @CrossOrigin
    @GetMapping("/sortD")
    private List<Course> getCoursesSortLHPagi(){
        return courseService.getCoursesSortLHPagi();
    }

    @CrossOrigin
    @GetMapping("/sortA")
    private List<Course> getCoursesSortHLPagi(){
        return courseService.getCoursesSortHLPagi();
    }
}