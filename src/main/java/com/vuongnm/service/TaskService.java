package com.vuongnm.service;

import com.vuongnm.model.Task;
import com.vuongnm.model.User;
import com.vuongnm.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
    }

    public List<Task> getTaskByUser(User user) {
        Optional<List<Task>> optionalTaskList = taskRepository.findByUser(user);
        if (optionalTaskList.isPresent()) {
            return optionalTaskList.get();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Task> getTaskByCompleted(Boolean completed) {
        Optional<List<Task>> optionalTaskList = taskRepository.getByCompleted(completed);
        if (optionalTaskList.isPresent()) {
            return optionalTaskList.get();
        } else {
            return Collections.emptyList();
        }
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDuedate(updatedTask.getDuedate());
            existingTask.setCompleted(updatedTask.getCompleted());
            existingTask.setUser(updatedTask.getUser());
            return taskRepository.save(existingTask);
        } else {
            throw new EntityNotFoundException("Task not found with ID: " + taskId);
        }
    }
}
