package com.vuongnm.controller;

import com.vuongnm.model.Label;
import com.vuongnm.model.Task;
import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.service.LabelService;
import com.vuongnm.service.TaskService;
import com.vuongnm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    //Method get all task
    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<Task>>> getAll() {
        return taskService.getAll();
    }

    //Method create a new task
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Task>> createUser(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    //Method get information of task by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    //Method get information of task by status(true/false)
    @GetMapping("/status/{completed}")
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByCompleted(@PathVariable Boolean completed) {
        return taskService.getTaskByCompleted(completed);
    }

    //Method get list task by username of user
    @GetMapping("/getByUsername/{userName}")
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByUsername(@PathVariable String userName) {
        User user = userService.getUserByUsername(userName).getBody().getData();
        return taskService.getTaskByUser(user);
    }

    //Method delete task by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return taskService.deleteById(id);
    }

    //Method update information of task by id
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateUser(@PathVariable Long id, @RequestBody Task task) {
        return taskService.getTaskById(id);
    }
}
