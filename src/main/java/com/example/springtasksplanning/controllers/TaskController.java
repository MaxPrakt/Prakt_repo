package com.example.springtasksplanning.controllers;


import com.example.springtasksplanning.config.MyUserDetails;
import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController{

    private TaskService taskService;

//    @GetMapping
//    public List<Task> findAllTasks() {
//
//        return taskService.findAllTasks();
//    }

    @GetMapping
    public List<Task> findTasksByAuthor(Authentication authentication) {
        //String author = principal.getName();
        Long userId = getUserId(authentication);
        return  taskService.findTasksByAuthorId(userId);
    }

    @PostMapping("save-task")
    public Task postTask(@RequestBody Task task){
        return taskService.postTask(task);

    }
    @PutMapping("update-task")
    public Task updateTask(@RequestBody Task task){

        return taskService.updateTask(task);
    }
    @DeleteMapping("delete-task/{id}")
    public void deleteTask(@PathVariable Long id){

        taskService.deleteTask(id);
    }
    private Long getUserId(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // Assuming your UserDetails contains user ID as a Long field
        return ((MyUserDetails) userDetails).getUserId();
    }
}
