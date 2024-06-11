
package com.example.springtasksplanning.controllers;


import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController{

    private TaskService taskService;

    private UserService userService;


    @GetMapping

    public List<TaskDTO> findTasksByAuthor(Authentication authentication) {

        Long userId = userService.getUserId(authentication);


        return taskService.findTasksByAuthorId(userId);
    }

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TaskDTO> findAllTasks() {
        return  taskService.findAllTasks();
    }

    @PostMapping("save-task")

    public TaskDTO postTask(@RequestBody @Valid TaskDTO task){

        return taskService.postTask(task);

    }
    @PutMapping("update-task")

    public TaskDTO updateTask(@RequestBody @Valid TaskDTO task, Authentication authentication){

        return taskService.updateTask(task, authentication);
    }
    @DeleteMapping("delete-task/{id}")

    public String deleteTask(@PathVariable Long id, Authentication authentication){

        return taskService.deleteTask(id, authentication);
    }


}
