package com.example.springtasksplanning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import java.util.Date;


@Data
@Entity
//@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String theme;
    private Date creation_date;
    private Date end_date;
    private String description;

}
