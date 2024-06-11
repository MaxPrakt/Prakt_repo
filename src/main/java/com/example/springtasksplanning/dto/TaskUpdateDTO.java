package com.example.springtasksplanning.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDTO {

    @Valid

    private Long id;

    @NotNull
    @Length(min = 6, max = 40, message = "Author's name must be longer than 6 symbols and shorter than 40")
    private String author;

    @NotNull
    @Length(min = 6, max = 60, message = "Theme must be longer than 6 symbols and shorter than 24")
    private String theme;

    private LocalDate creationDate;

    private LocalDate endDate;

    @NotNull
    @Length(min = 6, max = 400, message = "Theme must be longer than 6 symbols and shorter than 400")
    private String description;



}

