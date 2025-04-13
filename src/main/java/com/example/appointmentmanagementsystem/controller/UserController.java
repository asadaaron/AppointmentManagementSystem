/*
package com.example.appointmentmanagementsystem.controller;

import com.example.appointmentmanagementsystem.entity.User;
import com.example.appointmentmanagementsystem.entity.UserRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "user-list")
    public List<User> getUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
*/
