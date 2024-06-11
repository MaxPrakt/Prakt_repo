package com.example.springtasksplanning.services;

import com.example.springtasksplanning.dto.MyUserDTO;
import com.example.springtasksplanning.models.MyUser;
import org.springframework.security.core.Authentication;

public interface UserService {
    MyUser addUser(MyUserDTO myUser);

    Long getUserId(Authentication authentication);
    MyUser getUserById(Long id);
}
