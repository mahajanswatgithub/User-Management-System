package com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.controller;

import com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.entity.User;
import com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //read
    //get all users
    @GetMapping("users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    //create
    //add a user
    @PostMapping("user")
    public String addUser(@RequestBody User user)
    {
        return userService.addUsers(user);
    }


    //update the whole information of user
    @PutMapping("user/{userId}/{userName}/{address}/{phoneNumber}")
    public String updateUserInfo(@PathVariable Integer userId,@PathVariable String userName,@PathVariable String address,@PathVariable String phoneNumber)
    {
        return userService.updateUserInfo(userId,userName,address,phoneNumber);
    }

    //delete a specific user by userId
    @DeleteMapping("user/{userId}")
    public String deleteUserInfo(@PathVariable Integer userId)
    {
        return userService.removeInfo(userId);
    }

    //read
    //get user information by userId
    @GetMapping("userById/{userId}")
    public User getUserById(@PathVariable Integer userId)
    {
        return userService.getUserById(userId);
    }
}
