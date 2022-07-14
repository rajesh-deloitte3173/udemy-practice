package com.assignment.udemy.service;

import com.assignment.udemy.entity.Course;
import com.assignment.udemy.entity.User;
import com.assignment.udemy.repository.CourseRepo;
import com.assignment.udemy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepo courseRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> addUsers(List<User> users) {
        return userRepo.saveAll(users);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user, int id) {
        User userDb = userRepo.findById(id).get();
        System.out.println("before update: "+userDb.getName() + userDb.getBio() + userDb.getEmail() + userDb.getInterest());
        if (user.getName() != null)
            userDb.setName(user.getName());

        if (user.getBio() != null)
            userDb.setBio(user.getBio());

        if (user.getInterest() != null)
            userDb.setInterest(user.getInterest());

        System.out.println("after update: "+ userDb.getName() + userDb.getBio() + userDb.getEmail() + userDb.getInterest());

        return userRepo.save(userDb);
    }

    public User orderCourse(int uid, int cid) {
        User user = userRepo.findById(uid).get();
        Course course = courseRepo.findById(cid).get();
        user.addCourse(course);

        return userRepo.save(user);
    }

    public User getById(int id) {
        return userRepo.findById(id).get();
    }
}
