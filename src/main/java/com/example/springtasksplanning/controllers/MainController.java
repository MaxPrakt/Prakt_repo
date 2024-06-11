package com.example.springtasksplanning.controllers;

import com.example.springtasksplanning.dto.MyUserDTO;
import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MainController {

    private TaskService taskService;

    @GetMapping("/")
    public String index() {

        return "tasks";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        MyUserDTO user = new MyUserDTO();
        model.addAttribute("user", user);

        return "registration";
    }

    @GetMapping("/new-task")
    public String newTaskPage(Model model){
        TaskDTO task = new TaskDTO();
        model.addAttribute("task", task);
        return "new-task";
    }

    @GetMapping("/update-task/{id}")
    public String updateTaskPage(Model model, @PathVariable Long id) {

        TaskDTO task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

}
