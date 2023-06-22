package com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.service;

import com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.entity.User;
import com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public String addUsers(User user) {
        userRepo.add(user);
        return "User Added";
    }

    public String removeInfo(Integer userId) {
        for(User user : userRepo.getAllUsers())
        {
            if(user.getUserId().equals(userId))
            {
                userRepo.remove(user);
                return "user removed for user ID:" + userId;
            }

        }
        return "user :" + userId + " not deleted as it doesn't exist" ;
    }

    public String updateUserInfo(Integer userId, String userName, String address, String phoneNumber) {
        for(User user : userRepo.getAllUsers())
        {
            if(user.getUserId().equals(userId)) {
                user.setUserName(userName);
                user.setAddress(address);
                user.setPhoneNumber(phoneNumber);
            }
            return "User updated for User ID:" + userId;
        }
        return "User not found User ID: " + userId;
    }

    public User getUserById(Integer userId) {
        for(User user : userRepo.getAllUsers())
        {
            if(user.getUserId().equals(userId))
            {
                return user;
            }
        }
        throw new IllegalStateException("id not found");
    }
}
