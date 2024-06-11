package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.dto.TaskUpdateDTO;
import com.example.springtasksplanning.models.Task;
import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.repository.TaskRepository;
import com.example.springtasksplanning.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springtasksplanning.exceptions.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final UserService userService;


    @Override
    public List<TaskDTO> findTasksByAuthorId(Long authorId){
        List<Task> foundTasks = taskRepository.findByUserId(authorId);
        List<TaskDTO> tasksDTO = new ArrayList<>();
        for (Task task : foundTasks) {
            TaskDTO taskDTO = convertingTaskToDTO(task);
            tasksDTO.add(taskDTO);
        }
        return tasksDTO;

    }

    @Override

    public List<TaskDTO> findAllTasks() {
        List<Task> foundTasks = taskRepository.findAll();
        List<TaskDTO> tasksDTO = new ArrayList<>();
        for (Task task : foundTasks) {
            TaskDTO taskDTO = convertingTaskToDTO(task);
            tasksDTO.add(taskDTO);
        }
        return tasksDTO;
    }

    @Override
    public TaskDTO postTask(TaskDTO task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Task savedTask= convertingTaskFromDTO(task);
        Long userId = userService.getUserId(authentication);
        savedTask.setUser(userService.getUserById(userId));
        return convertingTaskToDTO(taskRepository.save(savedTask));

    }
    @Override
    public TaskUpdateDTO updateTask(TaskUpdateDTO task, Authentication authentication) {
        Task savedTask= convertingTaskFromDTO(task);
        Long userId = userService.getUserId(authentication);
        Task existingTask= taskRepository.findById(task.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        if(Objects.equals(existingTask.getUser().getId(), userId)
                || Objects.equals(userService.getUserById(userId).getRoles(), "ADMIN")){
            savedTask.setUser(existingTask.getUser());
            taskRepository.save(savedTask);
            return convertingTaskToUpdateDTO(savedTask);
        }
        else

            throw new AccessDeniedException();
    }



    @Override
    @Transactional
    public String deleteTask(long id, Authentication authentication) {
        Long userId = userService.getUserId(authentication);
        if (Objects.equals((taskRepository.findTaskById(id)).getUser().getId(), userId)
                || Objects.equals(userService.getUserById(userId).getRoles(), "ADMIN")) {
            taskRepository.deleteTaskById(id);

            return "task deleted";
        } else
            throw new AccessDeniedException();
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return convertingTaskToDTO(taskRepository.findTaskById(id));

    }


    @Override
    public TaskDTO convertingTaskToDTO(Task task) {
        TaskDTO savedTaskDTO = new TaskDTO();
        savedTaskDTO.setId(task.getId());
        savedTaskDTO.setAuthor(task.getAuthor());
        savedTaskDTO.setTheme(task.getTheme());
        savedTaskDTO.setCreationDate(task.getCreationDate());
        savedTaskDTO.setEndDate(task.getEndDate());
        savedTaskDTO.setDescription(task.getDescription());
        return savedTaskDTO;
    }
    @Override
    public TaskUpdateDTO convertingTaskToUpdateDTO(Task task) {
        TaskUpdateDTO savedTaskDTO = new TaskUpdateDTO();
        savedTaskDTO.setId(task.getId());
        savedTaskDTO.setAuthor(task.getAuthor());
        savedTaskDTO.setTheme(task.getTheme());
        savedTaskDTO.setCreationDate(task.getCreationDate());
        savedTaskDTO.setEndDate(task.getEndDate());
        savedTaskDTO.setDescription(task.getDescription());
        return savedTaskDTO;
    }

    @Override
    public Task convertingTaskFromDTO(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setAuthor(taskDTO.getAuthor());
        task.setTheme(taskDTO.getTheme());
        task.setCreationDate(taskDTO.getCreationDate());
        task.setEndDate(taskDTO.getEndDate());
        task.setDescription(taskDTO.getDescription());
        return task;
    }
    @Override
    public Task convertingTaskFromDTO(TaskUpdateDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setAuthor(taskDTO.getAuthor());
        task.setTheme(taskDTO.getTheme());
        task.setCreationDate(taskDTO.getCreationDate());
        task.setEndDate(taskDTO.getEndDate());
        task.setDescription(taskDTO.getDescription());
        return task;
    }
}
