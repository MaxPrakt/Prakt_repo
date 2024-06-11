package com.example.springtasksplanning.controllers;

import com.example.springtasksplanning.dto.MyUserDTO;
import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private  UserService userService;

    @PostMapping("/new-user")
    public MyUser addUser(@RequestBody @Valid MyUserDTO user) {

        return userService.addUser(user);
    }

}
