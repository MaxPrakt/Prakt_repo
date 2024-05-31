package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.models.MyUser;
import com.example.springtasksplanning.models.Task;

import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.repository.TaskRepository;
import com.example.springtasksplanning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final UserService userService;

//    @Override
//    public List<Task> findAllTasks() {
//
//        return taskRepository.findAll();
//    }

    @Override
    public List<Task> findTasksByAuthorId(Long authorId){

        return taskRepository.findByUserId(authorId);
    }

    @Override
    public Task postTask(Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Long userId = userService.getUserId(authentication);

            // Set the user to the task
            MyUser user = new MyUser();
            user.setId(userId);
            task.setUser(user);

            // Save the task
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("User is not authenticated");
        }

    }
    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    @Override
    @Transactional
    public void deleteTask(long id)
    {
        taskRepository.deleteById(id);
    }
}
