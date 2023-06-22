package com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.factory;

import com.example.SpringBootUserManagementSystem.demo.UserManagementSystem.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {

    @Bean
    public List<User> getDataSource()
    {
        return new ArrayList<>();
    }
}
