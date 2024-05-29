package com.example.springtasksplanning.repository;

import com.example.springtasksplanning.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long>{
}
