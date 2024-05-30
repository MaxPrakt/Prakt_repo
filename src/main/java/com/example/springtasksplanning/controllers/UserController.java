package com.example.springtasksplanning.controllers;

import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class UserController {
    private  UserService userService;

    @PostMapping("/new-user")
    public MyUser addUser(@RequestBody MyUser user) {
        return userService.addUser(user);
    }

}
