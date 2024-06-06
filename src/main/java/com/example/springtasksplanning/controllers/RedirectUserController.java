package com.example.springtasksplanning.controllers;


import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RedirectUserController {
    private TaskService taskService;

    private UserService userService;
    @GetMapping("/registration")
    public String newTask(Model model) {
        MyUser user = new MyUser();
        model.addAttribute("user", user);
        return "registration";


    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/new-user")

    public String addUser(MyUser user){

        userService.addUser(user);

        return "redirect:/";

    }
}
