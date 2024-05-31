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
    private String theme;
    private LocalDate creationDate;
    private LocalDate endDate;
    private String description;


    @ManyToOne
    @JoinColumn(name = "author_id") // Name of the foreign key column in the tasks table
    private MyUser user;

    //@Column(name = "author_id", insertable = false, updatable = false)
    //private Long authorId;




}
