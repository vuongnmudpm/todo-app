package com.vuongnm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String title;
    private String description;
    private Date dueDate;
    private String status;
    private Date createdDate;
    private String label;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
