package com.vuongnm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasklabels")
@IdClass(TaskLabel.class)
public class TaskLabel {
    @Id
    @ManyToOne
    @JoinColumn(name = "taskid")
    private Task task;
    @Id
    @ManyToOne
    @JoinColumn(name = "labelid")
    private Label label;
}
