package com.example.springtasksplanning.services;

import com.example.springtasksplanning.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    List<Task> findAllTasks();
    Task postTask(Task task);
    Task updateTask(Task task);
    void deleteTask(long id);
}
