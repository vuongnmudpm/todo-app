package com.vuongnm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasklabels")
@IdClass(TaskLabel.class)
public class TaskLabel implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;
    @Id
    @ManyToOne
    @JoinColumn(name = "labelId")
    private Label label;
}
