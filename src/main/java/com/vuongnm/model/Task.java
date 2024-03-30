package com.vuongnm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "task")
public class Task {
    @Id
    private long id;
    private String title;
    private String description;
    private Date due_date;
    private Boolean completed;
}
