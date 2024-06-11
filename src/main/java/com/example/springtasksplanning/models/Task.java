package com.example.springtasksplanning.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // Name of the foreign key column in the tasks table
    private MyUser user;

}
