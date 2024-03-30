package com.vuongnm.service;

import com.vuongnm.model.Task;
import com.vuongnm.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
