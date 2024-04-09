package com.vuongnm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskid;
    private String title;
    private String description;
    private Date duedate;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
