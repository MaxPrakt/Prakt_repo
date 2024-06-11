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
public class TaskDTO {

    @Valid

    private Long id;

    @NotNull
    @Length(min = 6, max = 40, message = "Author's name must be longer than 6 symbols and shorter than 40")
    private String author;

    @NotNull
    @Length(min = 6, max = 60, message = "Theme must be longer than 6 symbols and shorter than 24")
    private String theme;

    @NotNull
    @FutureOrPresent
    private LocalDate creationDate;

    @NotNull
    @FutureOrPresent
    private LocalDate endDate;

    @NotNull
    @Length(min = 6, max = 400, message = "Theme must be longer than 6 symbols and shorter than 400")
    private String description;

    @AssertTrue(message = "creationDate should be the current date")
    public boolean isCreationDateCurrent() {
        return creationDate.equals(LocalDate.now());
    }

    @AssertTrue(message = "endDate should be within one month from the current date")
    public boolean isEndDateWithinOneMonth() {

        LocalDate currentDate = LocalDate.now();
        LocalDate maxEndDate = currentDate.plusMonths(1);
        return !endDate.isAfter(maxEndDate);
    }

}
