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

        Long userId = userService.getUserId(authentication);

        List<TaskDTO> tasks= taskService.findTasksByAuthorId(userId);

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TaskDTO> findAllTasks() {
        return  taskService.findAllTasks();
    }
    @GetMapping("new-task")
    public String newTask(Model model, Authentication authentication) {
        Task task = new Task();
        model.addAttribute("taskDTO", task);
        return "new-task";


    }

    @PostMapping("save-task")

    public String postTask(@RequestBody Task task, Authentication authentication){

        Long userId = userService.getUserId(authentication);
        task.setUser(userService.getUserById(userId));

        return "redirect:/";

    }
    @PutMapping("update-task/{id}")

    public String updateTask(@RequestBody Long id, Model model){
        TaskDTO task =  taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }
    @GetMapping("delete-task/{id}")

    public String deleteTask(@PathVariable Long id, Authentication authentication){

        taskService.deleteTask(id, authentication);
        return "redirect:/";
    }
}
