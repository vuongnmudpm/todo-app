package com.vuongnm.controller;

import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //Method get all user
    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<User>>> getAll() {
        return ApiResponse.buildResponse(userService.getAll(), "success", true, HttpStatus.OK);
    }

    //Method create a new user
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        return ApiResponse.buildResponse(userService.createUser(user), "success", true, HttpStatus.OK);
    }

    //Method get information of user by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ApiResponse.buildResponse(user, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    //Method get information of user by username
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<ApiResponse<User>> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ApiResponse.buildResponse(user, "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    //Method delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (userService.getUserById(id) != null) {
            userService.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    //Method update information of user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.getUserById(id) != null) {
            return ApiResponse.buildResponse(userService.updateUser(id, user), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "success", true, HttpStatus.NOT_FOUND);
        }
    }
}
