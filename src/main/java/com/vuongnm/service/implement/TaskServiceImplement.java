package com.vuongnm.service.implement;

import com.vuongnm.model.Task;
import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.TaskRepository;
import com.vuongnm.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplement implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public ResponseEntity<ApiResponse<List<Task>>> getAll() {
        return ApiResponse.buildResponse(taskRepository.findAll(), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Task>> createTask(Task task) {
        return ApiResponse.buildResponse(taskRepository.save(task), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Task>> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return ApiResponse.buildResponse(optionalTask.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByUser(User user) {
        Optional<List<Task>> optionalTaskList = taskRepository.findByUser(user);
        if (optionalTaskList.isPresent()) {
            return ApiResponse.buildResponse(optionalTaskList.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(Collections.emptyList(), "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByCompleted(Boolean completed) {
        Optional<List<Task>> optionalTaskList = taskRepository.getByCompleted(completed);
        if (optionalTaskList.isPresent()) {
            return ApiResponse.buildResponse(optionalTaskList.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(Collections.emptyList(), "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if (taskRepository.findById(id) != null) {
            taskRepository.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Task>> updateTask(Long taskId, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDuedate(updatedTask.getDuedate());
            existingTask.setCompleted(updatedTask.getCompleted());
            existingTask.setUser(updatedTask.getUser());
            return ApiResponse.buildResponse(taskRepository.save(existingTask), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }
}
