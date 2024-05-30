package com.example.springtasksplanning.models;

import jakarta.persistence.*;

import lombok.Data;


import java.time.LocalDate;



@Data
@Entity
@Table (name ="tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private Long authorId;
    private String theme;
    private LocalDate creationDate;
    private LocalDate endDate;
    private String description;

}
