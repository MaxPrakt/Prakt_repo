package com.example.springtasksplanning.services;

import com.example.springtasksplanning.models.MyUser;
import org.springframework.security.core.Authentication;

public interface UserService {
    MyUser addUser(MyUser myUser);

    Long getUserId(Authentication authentication);
    MyUser getUserById(Long id);
}
