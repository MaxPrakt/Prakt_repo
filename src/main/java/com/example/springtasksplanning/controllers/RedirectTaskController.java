package com.example.springtasksplanning.controllers;



import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class RedirectTaskController {
    private TaskService taskService;

    private UserService userService;


    @GetMapping("/")

    public String findTasksByAuthor(Model model, Authentication authentication) {
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))){

            List<TaskDTO> tasks = taskService.findAllTasks();

            model.addAttribute("tasks", tasks);


        }
        else if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))){
            Long userId = userService.getUserId(authentication);

            List<TaskDTO> tasks = taskService.findTasksByAuthorId(userId);

            model.addAttribute("tasks", tasks);


        }
        return "tasks";
    }
    @GetMapping("/new-task")
    public String newTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "new-task";


    }

    @PostMapping("/save-task")

    public String postTask(Task task, Authentication authentication){

        Long userId = userService.getUserId(authentication);
        task.setUser(userService.getUserById(userId));
        taskService.postTask(task);

        return "redirect:/";

    }
    @GetMapping("/update-task/{id}")

    public String updateTask(@PathVariable(value = "id") Long id, Model model){
        TaskDTO task =  taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }
    @GetMapping("/delete-task/{id}")

    public String deleteTask(@PathVariable(value = "id") Long id, Authentication authentication){

        taskService.deleteTask(id, authentication);
        return "redirect:/";
    }
}
