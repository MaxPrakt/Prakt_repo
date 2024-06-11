package com.example.springtasksplanning.dto;

import com.example.springtasksplanning.customannotations.AgeConstraint;
import com.example.springtasksplanning.customannotations.PasswordComplexity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class MyUserDTO {
    @Valid

    private Long id;

    @NotNull(message = "Username is mandatory")
    @Length(min = 6, max = 24, message = "Username must be longer than 6 symbols and shorter than 24")
    private String userName;

    @Length(min = 8, max = 30, message = "Password must be longer than 8 symbols and shorter than 30")
    @NotNull(message = "Password is mandatory")
    @PasswordComplexity(message = "Password should be more complexly")
    private String password;

    @NotNull
    private String roles;

    @NotNull
    @AgeConstraint
    private LocalDate birthDate;
}
