package com.assignment.udemy.service;

import com.assignment.udemy.entity.Course;
import com.assignment.udemy.entity.User;
import com.assignment.udemy.repository.CourseRepo;
import com.assignment.udemy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        List<User> usersC = course.getUserCart();

        for (User user: users){
            User userDb = userRepo.findById(user.getId()).get();
            userDb.getOrderList().remove(course);
//            user.getOrderList().remove(course);
//            userDb.setOrderList(user.getOrderList());
            userRepo.save(userDb);
        }

        for (User user: usersC){
            User userDb = userRepo.findById(user.getId()).get();
            userDb.getCartList().remove(course);
            userRepo.save(userDb);
        }

        courseRepo.deleteById(id);
    }

    public List<Course> getCoursesSortLHPagi() {
        Pageable sortByPriceDfilter = PageRequest.of(
                0,
                3,
                Sort.by("price").ascending().and(Sort.by("name").and(Sort.by("domain")))
        );

        return courseRepo.findAll(sortByPriceDfilter).getContent();
    }

    public List<Course> getCoursesSortHLPagi() {
        Pageable sortByPriceAfilter = PageRequest.of(
                0,
                3,
                Sort.by("price").descending().and(Sort.by("name").and(Sort.by("domain")))
        );

        return courseRepo.findAll(sortByPriceAfilter).getContent();
    }
}
