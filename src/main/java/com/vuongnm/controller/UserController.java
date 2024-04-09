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
        return userService.getAll();
    }

    //Method create a new user
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //Method get information of user by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //Method get information of user by username
    @GetMapping("/getByUsername/{userName}")
    public ResponseEntity<ApiResponse<User>> getUserByUsername(@PathVariable String userName) {
        return userService.getUserByUsername(userName);
    }

    //Method delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    //Method update information of user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
