package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.config.MyUserDetails;
import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.repository.UserRepository;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Override
    public Long getUserId(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ((MyUserDetails) userDetails).getUserId();
    }
    @Override
    public MyUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
