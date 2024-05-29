package com.example.springtasksplanning.services.impl;

import com.example.springtasksplanning.models.Task;

import com.example.springtasksplanning.services.TaskService;
import com.example.springtasksplanning.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasks() {

        return taskRepository.findAll();
    }
    @Override
    public Task postTask(Task task) {
        return taskRepository.save(task);
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
