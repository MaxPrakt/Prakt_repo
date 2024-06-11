package com.example.springtasksplanning.services;

import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.dto.TaskUpdateDTO;
import com.example.springtasksplanning.models.Task;
import org.springframework.security.core.Authentication;
import java.util.List;

public interface TaskService {

    List<TaskDTO> findTasksByAuthorId(Long authorId);
    List<TaskDTO> findAllTasks();
    TaskDTO postTask(TaskDTO task);
    TaskUpdateDTO updateTask(TaskUpdateDTO task, Authentication authentication);
    TaskDTO getTaskById(Long id);
    String deleteTask(long id, Authentication authentication);
    TaskDTO convertingTaskToDTO(Task task);
    TaskUpdateDTO convertingTaskToUpdateDTO(Task task);
    Task convertingTaskFromDTO(TaskDTO taskDTO);
    Task convertingTaskFromDTO(TaskUpdateDTO taskDTO);
}
