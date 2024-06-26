package com.example.springtasksplanning.repository;

import com.example.springtasksplanning.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findByUserId(Long id);


    void deleteTaskById(long id);

    Task findTaskById(long id);
}
