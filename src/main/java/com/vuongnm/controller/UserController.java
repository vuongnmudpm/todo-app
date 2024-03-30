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
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //Method get all data
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
    public ResponseEntity<ApiResponse<Optional<User>>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ApiResponse.buildResponse(userService.getUserById(id), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(userService.getUserById(id), "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        if(userOptional.isPresent()) {
            return ApiResponse.buildResponse(userService.deleteById(id), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(userService.deleteById(id), "false", false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userUpdate = userService.updateUser(id, user);
        return ApiResponse.buildResponse(userService.updateUser(id, user), "success", true, HttpStatus.OK);
    }

}
