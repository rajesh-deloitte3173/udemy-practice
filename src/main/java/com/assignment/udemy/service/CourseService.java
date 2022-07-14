package com.assignment.udemy.service;

import com.assignment.udemy.entity.Course;
import com.assignment.udemy.entity.User;
import com.assignment.udemy.repository.CourseRepo;
import com.assignment.udemy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> addListCourses(List<Course> courses) {
        return courseRepo.saveAll(courses);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public void deleteCourse(int id) {
        Course course = courseRepo.findById(id).get();
        List<User> users = course.getUserOrder();

        for (User user: users){
            User userDb = userRepo.findById(user.getId()).get();
            user.getOrderList().remove(course);
            userDb.setOrderList(user.getOrderList());
            userRepo.save(userDb);
        }

        courseRepo.deleteById(id);
    }
}
