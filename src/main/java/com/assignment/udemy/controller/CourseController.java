package com.assignment.udemy.controller;

import com.assignment.udemy.entity.Course;
import com.assignment.udemy.entity.User;
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

    @PostMapping
    private Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PostMapping("/list")
    private List<Course> addListCourses(@RequestBody List<Course> courses){
        return courseService.addListCourses(courses);
    }

    @GetMapping
    private List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @DeleteMapping("/{id}")
    private void deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
    }
}
