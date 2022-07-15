package com.assignment.udemy.controller;

import com.assignment.udemy.entity.User;
import com.assignment.udemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping
    private User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @CrossOrigin
    @PostMapping("/list")
    private List<User> addUsers(@RequestBody List<User> users){
        return userService.addUsers(users);
    }

    @CrossOrigin
    @GetMapping
    private List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private User updateUser(@RequestBody User user, @PathVariable("id") int id){
        return userService.updateUser(user, id);
    }

    @CrossOrigin
    @PutMapping("/{uid}/{cid}")
    private User orderCourse(@PathVariable("uid") int uid, @PathVariable("cid") int cid){
        return userService.orderCourse(uid, cid);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private User getById(@PathVariable("id") int id){
        return userService.getById(id);
    }

    @CrossOrigin
    @PutMapping("/cart/{uid}/{cid}")
    private User addCoursetoCart(@PathVariable("uid") int uid, @PathVariable("cid") int cid){
        return userService.addCoursetoCart(uid,cid);
    }

    @CrossOrigin
    @PutMapping("/cart/remove/{uid}/{cid}")
    private User removeCourseFromCart(@PathVariable("uid") int uid, @PathVariable("cid") int cid){
        return userService.removeCourseFromCart(uid,cid);
    }
}
