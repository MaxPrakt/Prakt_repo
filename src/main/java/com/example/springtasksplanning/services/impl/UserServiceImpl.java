package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.repository.UserRepository;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override

    public MyUser addUser(MyUser myUser) {
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return userRepository.save(myUser);
    }
}
