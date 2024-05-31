package com.example.springtasksplanning.services;

import com.example.springtasksplanning.models.Task;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    //List<Task> findAllTasks();
    //List<Task> findTasksByAuthor(String author);

    List<Task> findTasksByAuthorId(Long authorId);
    Task postTask(Task task);
    Task updateTask(Task task);
    void deleteTask(long id);
}
