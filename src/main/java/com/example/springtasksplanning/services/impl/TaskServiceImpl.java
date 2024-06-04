package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.models.Task;

import com.example.springtasksplanning.dto.TaskDTO;
import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.repository.TaskRepository;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
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
    public TaskDTO postTask(Task task) {

        Task savedTask= taskRepository.save(task);

        return convertingTaskToDTO(savedTask);

    }
    @Override
    public TaskDTO updateTask(Task task, Authentication authentication) {
        Long userId = userService.getUserId(authentication);
        if(Objects.equals(task.getUser().getId(), userId)
                || Objects.equals(userService.getUserById(userId).getRoles(), "ADMIN")){

            Task savedTask= taskRepository.save(task);
            return convertingTaskToDTO(savedTask);
        }
        else

            throw new AccessDeniedException();
    }
    @Override
    @Transactional
    public String deleteTask(long id, Authentication authentication) {
        Long userId = userService.getUserId(authentication);
        if(Objects.equals((taskRepository.findTaskById(id)).getUser().getId(), userId)
                || Objects.equals(userService.getUserById(userId).getRoles(), "ADMIN")) {
            taskRepository.deleteTaskById(id);

            return "task deleted";
        }
        else throw new AccessDeniedException();
    }

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
}
