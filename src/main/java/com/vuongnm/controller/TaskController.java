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
        return ApiResponse.buildResponse(taskService.getAll(), "success", true, HttpStatus.OK);
    }

    //Method create a new task
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Task>> createUser(@RequestBody Task task) {
        return ApiResponse.buildResponse(taskService.createTask(task), "success", true, HttpStatus.OK);
    }

    //Method get information of task by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return ApiResponse.buildResponse(task, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    //Method get information of task by status(true/false)
    @GetMapping("/status/{completed}")
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByCompleted(@PathVariable Boolean completed) {
        List<Task> list = taskService.getTaskByCompleted(completed);
        if (list != null) {
            return ApiResponse.buildResponse(list, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    //Method get list task by username of user
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<ApiResponse<List<Task>>> getTaskByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        List<Task> taskList = taskService.getTaskByUser(user);
        if (taskList != null) {
            return ApiResponse.buildResponse(taskList, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    //Method delete task by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (taskService.getTaskById(id) != null) {
            taskService.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    //Method update information of task by id
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateUser(@PathVariable Long id, @RequestBody Task task) {
        Task taskExist = taskService.getTaskById(id);
        if (taskExist != null) {
            return ApiResponse.buildResponse(taskService.updateTask(id, task), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }
}
