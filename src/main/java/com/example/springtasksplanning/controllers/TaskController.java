package com.example.springtasksplanning.controllers;


import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController{

    private TaskService taskService;

    @GetMapping
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }
    @PostMapping("save_task")
    public String postTask(@RequestBody Task task){
        taskService.postTask(task);
        return "task saved";
    }
    @PutMapping("update_task")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }
    @DeleteMapping("delete_task/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
