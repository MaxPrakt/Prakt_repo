package com.example.springtasksplanning.services.impl;
import com.example.springtasksplanning.config.MyUserDetails;
import com.example.springtasksplanning.dto.MyUserDTO;
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

    public MyUser addUser(MyUserDTO myUser) {
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));

        return userRepository.save(fromDTOConverter(myUser));
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

    public MyUser fromDTOConverter(MyUserDTO userDTO)
    {
        MyUser myUser = new MyUser();
        myUser.setId(userDTO.getId());
        myUser.setUserName(userDTO.getUserName());
        myUser.setPassword(userDTO.getPassword());
        myUser.setRoles(userDTO.getRoles());
        myUser.setBirthDate(userDTO.getBirthDate());
        return myUser;

    }

}
