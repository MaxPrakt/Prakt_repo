
package com.example.springtasksplanning.controllers;


import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController{

    private TaskService taskService;
    //private final TaskAuthorizationService authorizationService;
    private UserService userService;



    @GetMapping

    public List<Task> findTasksByAuthor(Authentication authentication) {

        Long userId = userService.getUserId(authentication);
        return  taskService.findTasksByAuthorId(userId);
    }

    @PostMapping("save-task")

    public Task postTask(@RequestBody Task task, Authentication authentication){

        //Long userId = userService.getUserId(authentication);
        //task.setUser(userService.getUserById(userId));
        return taskService.postTask(task);

    }
    @PutMapping("update-task")

    public Task updateTask(@RequestBody Task task, Authentication authentication){

        return taskService.updateTask(task);
    }
    @DeleteMapping("delete-task/{id}")

    public void deleteTask(@PathVariable Long id, Authentication authentication){

        taskService.deleteTask(id);
    }

}
