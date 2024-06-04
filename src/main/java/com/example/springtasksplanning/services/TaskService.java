package com.example.springtasksplanning.services;

import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.dto.TaskDTO;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface TaskService {

    List<TaskDTO> findTasksByAuthorId(Long authorId);
    List<TaskDTO> findAllTasks();
    TaskDTO postTask(Task task);
    TaskDTO updateTask(Task task, Authentication authentication);
    String deleteTask(long id, Authentication authentication);
}
