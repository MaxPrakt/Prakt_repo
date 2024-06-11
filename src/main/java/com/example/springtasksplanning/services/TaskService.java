package com.example.springtasksplanning.services;

import com.example.springtasksplanning.dto.TaskDTO;
import org.springframework.security.core.Authentication;
import java.util.List;

public interface TaskService {

    List<TaskDTO> findTasksByAuthorId(Long authorId);
    List<TaskDTO> findAllTasks();
    TaskDTO postTask(TaskDTO task);
    TaskDTO updateTask(TaskDTO task, Authentication authentication);
    TaskDTO getTaskById(Long id);
    String deleteTask(long id, Authentication authentication);


}
