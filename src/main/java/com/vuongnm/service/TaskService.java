package com.vuongnm.service;

import com.vuongnm.model.Task;
import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    public ResponseEntity<ApiResponse<List<Task>>> getAll();

    public ResponseEntity<ApiResponse<Task>> createTask(Task task);

    public ResponseEntity<ApiResponse<Task>> getTaskById(Long id);

    public ResponseEntity<ApiResponse<List<Task>>> getTaskByUser(User user);

    public ResponseEntity<ApiResponse<List<Task>>> getTaskByCompleted(Boolean completed);

    public ResponseEntity<String> deleteById(Long id);

    public ResponseEntity<ApiResponse<Task>> updateTask(Long taskId, Task updatedTask);

    public ResponseEntity<ApiResponse<List<Task>>> getTodosDueToday();
}
