package com.example.springtasksplanning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long id;

    private String author;
    private String theme;
    private LocalDate creationDate;
    private LocalDate endDate;
    private String description;

}
